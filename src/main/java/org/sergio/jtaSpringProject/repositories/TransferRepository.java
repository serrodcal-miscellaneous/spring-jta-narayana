package org.sergio.jtaSpringProject.repositories;

import org.sergio.jtaSpringProject.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
