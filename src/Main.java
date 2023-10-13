import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> libros = new ArrayList<>();

        libros.add(new Book("Programming", 750, "Fatine"));
        libros.add(new Book("CSS", 250, "John John"));
        libros.add(new Book("Dev", 750, "Claudia"));
        libros.add(new Book("HTML", 1150, "John John"));
        libros.add(new Book("AR", 150, "Ana"));


        long cantidad1 = libros.stream()
                .filter(p -> p.getPages()>500)
                .count();

        long cantidad2 = libros.stream()
                .filter(p -> p.getPages()<300)
                .count();

        System.out.println("1. Cantidad de libros con más de 500 páginas: " + cantidad1);
        System.out.println("2. Cantidad de libros con menos de 300 páginas: " + cantidad2);

        System.out.println("3. Título de todos aquellos libros con más de 500 páginas: ");

        libros.stream()
        .filter(p -> p.getPages()>500)
        .map(Book::getTitle)
        .forEach(System.out::println);

        // TODO: CORREGIR

        System.out.println("4. Título de los 3 libros con mayor número de páginas.");
        libros.stream().sorted((p1, p2) -> Integer.compare(p2.getPages(), p1.getPages()))
                .limit(3)
                .map(Book::getTitle)
                .forEach(System.out::println);

        int suma = libros.stream()
                .mapToInt(Book::getPages)
                .sum();

        System.out.println("5. Suma total de las páginas de todos los libros: " + suma);

        double media = libros.stream()
                .mapToInt(Book::getPages)
                .average().getAsDouble();

        // System.out.println("Media de páginas: " + media);

        System.out.println("6. Libros que superen el promedio en cuanto a número de páginas se refiere: ");
        libros.stream()
                .filter(p -> p.getPages() > media)
                .map(Book::getTitle)
                .forEach(System.out::println);

        System.out.println("7. Autores de todos los libros, sin repetir nombres de autores.");

        libros.stream()
                .map(Book::getAuthor).distinct()
                .forEach(System.out::println);

        // System.out.println("8. Autores que tengan más de 1 libro listado.");
        // TODO: CORREGIR

        double libroMax = libros.stream().mapToDouble(Book::getPages)
                .max().getAsDouble();

        System.out.println("9. Libro con mayor número de páginas: " + libroMax);

        System.out.println("10. Colección con todos los títulos de los libros.");
        List<String> titles = libros.stream().map(Book::getTitle).toList();


    }
}