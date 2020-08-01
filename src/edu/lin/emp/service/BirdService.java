package edu.lin.emp.service;

import edu.lin.emp.entity.Bird;
import edu.lin.emp.util.Pager;

import java.util.Map;

public interface BirdService {

    /*List<Bird> birdList();*/

    int login(Map<String, Object> params);

    Pager<Bird> loadUsersListPager(int currantPage);

    int delete(Map<String, Object> params);

    int delSelected(String[] ids);

    int save(Map<String, Object> params);
}
