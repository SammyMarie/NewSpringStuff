package uk.co.capita.model;

/**
 * Created by smlif on 31/01/2016.
 */
public class BookDetail {
    private String authorName;
    private String bookTitle;
    private String isbnNumber;

    //This is for having
    public BookDetail(){

    }

    public BookDetail(String authorName, String bookTitle, String isbnNumber){
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.isbnNumber = isbnNumber;
    }

    public void setAuthorName(String authorName) {

        this.authorName = authorName;
    }

    public void setBookTitle(String bookTitle) {

        this.bookTitle = bookTitle;
    }

    public void setIsbnNumber(String isbnNumber) {

        this.isbnNumber = isbnNumber;
    }

    public String getAuthorName() {

        return authorName;
    }

    public String getBookTitle() {

        return bookTitle;
    }

    public String getIsbnNumber() {

        return isbnNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if(bookTitle == null){
            result *= prime + 0;
        }else{
            result *= prime + bookTitle.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        // Check if object is an instance of BookDetail
        if (!(object instanceof BookDetail)) {
            return false;
        }

        // Typecast object to BookDetail to compare data members
        BookDetail bookDetail = (BookDetail) object;

        // Compare the data members and return accordingly
        return bookDetail.getBookTitle().equals(bookTitle);
    }
}

