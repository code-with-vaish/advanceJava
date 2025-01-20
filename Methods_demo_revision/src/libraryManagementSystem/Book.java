package libraryManagementSystem;

public class Book {
	
  private String title;
  private 	String author;
  private	int isbn;
  
  public Book()
  {
	  super();
  }
  
  
  public Book(String title, String author, int isbn) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
}
  
public String getTitle() {
	return title;
}

public String getAuthor() {
	return author;
}

public int getIsbn() {
	return isbn;
}

public String toString() {
	return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
}


}
