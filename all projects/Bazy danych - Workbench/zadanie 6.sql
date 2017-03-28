set global sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';
select @@sql_mode;
select @@global.sql_mode;



#Zadanie 1
# liczba aktywnych uzytkowników forum na dzien 2015-12-17 po dacie ostatniego posta. 
# USER jest aktywny jesli ostatni post jest umieszczony nie wczesniej niz 3m-ce temu



set @start_date = '2015-09-01';
set @stop_date = '2015-12-17';

SELECT 
    COUNT(last_post) AS count_active_users
FROM
    forum.users
WHERE
    FROM_UNIXTIME(last_post) BETWEEN @start_date AND @stop_date;
    

#Zdadanie 2
# najbardziej aktywny user w roku X wg liczby postów

SELECT 
    poster AS username, poster_id, YEAR(FROM_UNIXTIME(posted)) as year, COUNT(message) AS sum_of_post
FROM
    forum.posts
WHERE
    YEAR(FROM_UNIXTIME(posted)) = 2015
GROUP BY poster_id
HAVING poster_id != 1
ORDER BY sum_of_post DESC
LIMIT 1;



#Zdadanie 3
# 5 uzytkownikow, ktorych suma wszystkich komentarzy jest najdluzsza

SELECT 
    poster AS username, poster_id, sum(length(message)) AS length_all_message
FROM
    forum.posts
GROUP BY poster_id
HAVING poster_id != 1
ORDER BY length_all_message DESC
LIMIT 5;



#Zadanie 4
# uzytkownik, ktory nie napisal zadnego message
SELECT 
    username
FROM
    forum.users
        LEFT JOIN
    forum.posts ON users.id = posts.poster_id
WHERE
    posts.message IS NULL;


# Zadanie 5
# userzy, ktorzy proponowali rzeczy niezgodne z prawem
SELECT 
    poster AS username, message
FROM
    forum.posts
WHERE
	message LIKE 'sprzedam%amf%';


#Zadanie 6
# z jakiej najczesciej poczty korzystają userzy
    SELECT 
    SUBSTRING_INDEX(email, '@', - 1),
    COUNT(SUBSTRING_INDEX(email, '@', - 1)) AS number_users_using_serwer
FROM
    forum.users
GROUP BY SUBSTRING_INDEX(email, '@', - 1)
ORDER BY COUNT(SUBSTRING_INDEX(email, '@', - 1)) DESC; 

    
