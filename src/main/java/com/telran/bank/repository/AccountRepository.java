
package com.telran.bank.repository;


import com.telran.bank.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public  interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByCity(List<String> cityes);

}
