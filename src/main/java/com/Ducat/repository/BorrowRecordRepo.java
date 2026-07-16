package com.Ducat.repository;

import com.Ducat.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepo extends JpaRepository<BorrowRecord,Integer> {
}
