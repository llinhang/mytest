package edu.lin.emp.dao;

import edu.lin.emp.entity.Bird;

import java.util.List;
import java.util.Map;

public interface BirdMapper {

    List<Bird> birdList();

    int login(Map<String, Object> params);

    int delete(Map<String, Object> params);

    int delete(int id);

    int save(Map<String, Object> params);
}
