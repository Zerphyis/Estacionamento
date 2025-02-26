package com.dev.Zerphyis.estaciona.repositorys;

import com.dev.Zerphyis.estaciona.entity.entryExit.EntryExit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryExitRepository extends JpaRepository<EntryExit ,Long> {
}
