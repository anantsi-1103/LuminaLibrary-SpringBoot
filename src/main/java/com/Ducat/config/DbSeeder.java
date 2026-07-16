package com.Ducat.config;

import com.Ducat.model.Book;
import com.Ducat.model.Member;
import com.Ducat.repository.BookRepo;
import com.Ducat.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Order(1)
@Component
public class DbSeeder implements CommandLineRunner {

    private final BookRepo bookRepo;
    private final MemberRepo memberRepo;


    public DbSeeder(BookRepo bookRepo, MemberRepo memberRepo) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        seedIfEmpty();
    }


    private void seedIfEmpty() {
//        Seed data to book if book table is empty
        if (bookRepo.count() == 0) {
            System.out.println("[Seeding] Database books inventory is empty. Seeding mock entries...");
            bookRepo.save(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 3, 3));
            bookRepo.save(new Book("1984", "George Orwell", "9780451524935", "Dystopian", 4, 4));
            bookRepo.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 2, 2));
            bookRepo.save(new Book("Introduction to Java", "Herbert Schildt", "9781260463415", "Education", 5, 5));
            bookRepo.save(new Book("Clean Code", "Robert C. Martin", "9780132350884", "Technology", 2, 2));
            System.out.println("[Seeding] 5 books successfully seeded.");
        }

        //        Seed data to member if member table is empty
        if (memberRepo.count() == 0) {
            System.out.println("[Seeding] Database members registry is empty. Seeding mock entries...");
            String joinDate = LocalDate.now().toString();
            memberRepo.save(new Member("Alice Smith", "alice.smith@email.com", "555-0199", joinDate));
            memberRepo.save(new Member("Bob Jones", "bob.jones@email.com", "555-0144", joinDate));
            memberRepo.save(new Member("Charlie Brown", "charlie.brown@email.com", "555-0177", joinDate));
            System.out.println("[Seeding] 3 members successfully seeded.");
        }

    }
}
