package com.example.StoreProject.repository.depositRepository;

import com.example.StoreProject.entity.deposit.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {


    @Query("SELECT SUM(d.totalNumbersDevice) FROM Deposit d WHERE d.idDeposit = :depositId")
    Integer countTotalDevicesInDeposit(Integer depositId);

    Object deleteByIdDeposit(Integer idDeposit);
}
