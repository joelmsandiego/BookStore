# BookStore

database name : book_store
database table: book_info
run service first then portal


http://localhost:8080/book-store-portal/ws/BookStore/FilteredBook
{
  "author": "joel"
}
http://localhost:8080/book-store-portal/ws/BookStore/DeleteBook 
{
  	"bookId":5
}
http://localhost:8080/book-store-portal/ws/BookStore/RenameBook
{
    "bookId":5,
    "author": "joel"
}
http://localhost:8080/book-store-portal/ws/BookStore/AddBook
{
  "bookTittle": "sample title",
  "bookAuthor" : joel,
  "bookGenre" : action,
  "price": 500,
  "createdBy" : joel
}
http://localhost:8080/book-store-portal/ws/BookStore/ShowAllBooks
execute by get
