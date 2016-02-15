package uk.co.capita.dao;

import org.marc4j.MarcReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;
import uk.co.capita.model.BookDetail;
import uk.co.capita.service.MarcRead;

import java.io.InputStream;
import java.util.*;

/**
 * Created by smlif on 31/01/2016.
 */
public class MarcReaderBean implements MarcRead {

    private BookDetail books;
    private BookDetail bookDetail;

    @Override
    public List<BookDetail> xmlReader(String author) {
        String authorsName = author;

        MarcReader reader = getMarcReader();

        List<BookDetail> bookDetails = new ArrayList<>();
        books = new BookDetail();

        while (reader.hasNext()) {
            Record record = reader.next();

            if("Iain Banks".equals(authorsName)){
                authorsName = "Banks";
            }else if("Iain M. Banks".equals(authorsName)){
                authorsName = "Banks";
            }

            List result = record.find(authorsName);

            if(!result.isEmpty()){
                DataField field = (DataField)result.get(0);
                Subfield authorSubfield = field.getSubfield('a');
                books.setAuthorName(authorSubfield.getData());

                DataField title = (DataField) record.getVariableField("245");
                Subfield titleSubfield = title.getSubfield('a');
                books.setBookTitle(titleSubfield.getData().replaceAll("[^a-zA-Z]+", " ").trim());

                DataField isbn = (DataField) record.getVariableField("020");
                Subfield isbnSubfield = isbn.getSubfield('a');
                books.setIsbnNumber(isbnSubfield.getData().replaceAll("[\\D.]", "").trim());

                bookDetail = new BookDetail(books.getAuthorName(), books.getBookTitle(), books.getIsbnNumber());

                if(!bookDetails.contains(bookDetail))
                    bookDetails.add(bookDetail);
            }
        }
        return bookDetails;
    }

    private static MarcReader getMarcReader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("banks.xml");
        return new MarcXmlReader(inputStream);
    }
}
