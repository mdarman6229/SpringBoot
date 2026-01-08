package com.metroDriverManagmentSystem.repositories;


import com.metroDriverManagmentSystem.entities.MetroDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetroDriverRepository extends JpaRepository<MetroDriver,Long> {

}
