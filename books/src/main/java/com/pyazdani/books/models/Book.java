package com.pyazdani.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat; 

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Size(min = 5, max = 200)
    private String title;
    
    @Column
    @Size(min = 5, max = 200)
    private String description;
    
    @Column
    @Size(min = 3, max = 40)
    private String language;
    
    @Column
    @Min(100)
    private int numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
        
      public Book() {
      }
      
      public Book(String title, String desc, String lang, int pages) {
          this.title = title;
          this.description = desc;
          this.language = lang;
          this.numberOfPages = pages;
      }
    
	    public String getTitle() {
	    		return title;
		}
		public void setTitle(String title) {
		    this.title = title;
		}
		public String getDescription() {
		    return description;
		}
		public void setDescription(String description) {
		    this.description = description;
		}
		public String getLanguage() {
		    return language;
		}
		public void setLanguage(String language) {
		    this.language = language;
		}
		public int getNumberOfPages() {
		    return numberOfPages;
		}
		public void setNumberOfPages(int numberOfPages) {
		    this.numberOfPages = numberOfPages;
		}
    
}
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;
//public class Book {     
////    private String title;
////    private String description;
////    private String language;
////    private int numberOfPages;
//  // ANNOTATE MODEL/MEMBER VARIABLES WITH VALIDATION REQUIREMENTS BELOW
//      @Size(min = 3, max = 20)
//        private String title;
//        
//      @Size(min = 5, max = 200)
//        private String description;
//        
//      @Size(min = 3, max = 40)
//        private String language;
//        
//      @Min(100)
//        private int numberOfPages;
//    
//    
//    public Book() {
//    }
//    
//    public Book(String title, String desc, String lang, int pages) {
//        this.title = title;
//        this.description = desc;
//        this.language = lang;
//        this.numberOfPages = pages;
//    }
//    
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public String getLanguage() {
//        return language;
//    }
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//    public int getNumberOfPages() {
//        return numberOfPages;
//    }
//    public void setNumberOfPages(int numberOfPages) {
//        this.numberOfPages = numberOfPages;
//    }
//}
//    