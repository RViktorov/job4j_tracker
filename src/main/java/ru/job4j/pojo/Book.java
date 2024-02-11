package ru.job4j.pojo;

public class Book {
   private int numberPages;
  private String nameBook;

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Book (String nameBook, int numberPages) {
     this.nameBook=nameBook;
     this.numberPages=numberPages;

  }
}