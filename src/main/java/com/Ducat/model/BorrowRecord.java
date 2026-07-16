package com.Ducat.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "borrow_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @NotBlank(message = "Borrow date cannot be blank")
    private String borrowDate;

    private String returnDate;

    @NotBlank(message = "Status Cannot be Blank")
    @Pattern(regexp = "BORROWED|RETURNED", message = "Status must be Borrowed or Returned")
    private String status;

    private double fineAmount;


}
