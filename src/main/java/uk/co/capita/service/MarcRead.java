package uk.co.capita.service;

import uk.co.capita.model.BookDetail;

import java.util.List;

/**
 * Created by smlif on 31/01/2016.
 */
public interface MarcRead {
    List<BookDetail> xmlReader(String author);
}
