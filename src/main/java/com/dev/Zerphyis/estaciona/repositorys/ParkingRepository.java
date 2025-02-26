package com.dev.Zerphyis.estaciona.repositorys;

import com.dev.Zerphyis.estaciona.entity.parking.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking , Long> {
}
