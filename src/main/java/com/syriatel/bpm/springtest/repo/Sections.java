package com.syriatel.bpm.springtest.repo;

import com.syriatel.bpm.springtest.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sections extends JpaRepository<Section,Long> {
}
