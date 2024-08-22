package com.TestMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestMapping.entity.Mission;

public interface MissionRepostiory extends JpaRepository<Mission, Long> {

}
