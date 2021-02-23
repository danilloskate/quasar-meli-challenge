package com.meli.quasar.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.quasar.entity.Satellites;



public interface SatellitesRepository extends JpaRepository<Satellites, String> {
}
