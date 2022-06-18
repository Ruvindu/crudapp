package com.dfn.crudapp.repository;

import com.dfn.crudapp.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Long> {
}
