
package ru.biponline.demo.utils;

import ru.biponline.demo.entity.AuthorEntity;
import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.entity.PublisherEntity;
import ru.biponline.demo.exception.ValidationExceptionBook;
public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationExceptionBook {
        String bookTitle = book.getTitle();
        if(bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3 || bookTitle.length() > 35)
            throw new ValidationExceptionBook("Название книги должно быть в приделах от 3 до 35 символов");
        AuthorEntity author = book.getAuthor();
        if(author == null) //|| author.getName().isBlank() || author.getName().length() < 3 || author.getName().length() > 15
            throw new ValidationExceptionBook("Имя автора должно быть в приделах от 4 до 15");
        PublisherEntity publishing = book.getPublishing();
        if (publishing == null) //|| publishing.getPublishing().isBlank() || publishing.getPublishing().length() < 3 || publishing.getPublishing().length() > 30
            throw new ValidationExceptionBook("Название издательства должна быть от 3 до 30 символов");
        String kind = book.getKind();
        if (kind == null || kind.isBlank() || kind.length() < 3 || kind.length() > 30)
            throw new ValidationExceptionBook("Жанр должен быть от 3 до 30 символов");
    }
}
/*
public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        String author = book.getAuthor();
        if (author == null || author.isBlank() || author.length()<3 || author.length() > 35) {
            throw new ValidationException("Автор должен быть в пределах от 3 до 35 символов!");
        }

        String title = book.getTitle();
        if (title == null || title.isBlank() || title.length()<3 || title.length() > 35) {
            throw new ValidationException("Название должно быть в пределах от 3 до 35 символов!");
        }

        String publishing = book.getPublishing();
        if (publishing == null || publishing.isBlank() || publishing.length()<3 || publishing.length() > 35) {
            throw new ValidationException("Издательство должно быть в пределах от 3 до 35 символов!");
        }

        String kind = book.getKind();
        if (kind == null || kind.isBlank() || kind.length()<3 || kind.length() > 35) {
            throw new ValidationException("Жанр должен быть в пределах от 3 до 35 символов!");
        }

        int year = book.getYear();
        if (year > 2033) {
            throw new ValidationException("Книга не может быть из будущего!");
        }
    }
}
*/

