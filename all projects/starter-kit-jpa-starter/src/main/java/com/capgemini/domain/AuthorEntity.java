//package com.capgemini.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "AUTHOR")
//public class AuthorEntity implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @Column(nullable = false, length = 50)
//    private String firstName;
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    //for hibernate
//    protected AuthorEntity() {
//
//    }
//
//    public AuthorEntity(Long id, String firstName, String lastName) {
//        this(firstName, lastName);
//        this.id = id;
//    }
//
//    public AuthorEntity(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//}
