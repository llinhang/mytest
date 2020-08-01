package edu.lin.emp.controller;

import com.google.gson.Gson;
import edu.lin.emp.entity.Bird;
import edu.lin.emp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lin
 * @time: 2020/7/31 19:17
 */

@Controller
public class BirdController {

    @Autowired
    private BirdService birdService;

   /* @RequestMapping("list")
    public Object list(){
        List<Bird> birds = birdService.birdList();
        System.out.println(birds);
        return birds;
    }*/
    @RequestMapping("login")
    public void login( Bird bird,
                       HttpServletResponse response) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ba", bird.getBirdAccount());
        map.put("bp", bird.getBirdPwd());

        // 1
        response.setContentType("text/html;charset=utf-8");
        // 2
        PrintWriter out = response.getWriter();

        int loginCount = this.birdService.login(map);
        out.print(new Gson().toJson(loginCount));
        out.close();

    }
    @RequestMapping("loadUsersListPager")
    public ModelAndView loadUsersListPager(int currentPage, HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("utf-8");
        PrintWriter out= response.getWriter();
        out.print(new Gson().toJson(this.birdService.loadUsersListPager(currentPage)));
        System.out.println(new Gson().toJson(this.birdService.loadUsersListPager(currentPage)));
        out.close();
        return null;
    }

    @RequestMapping("delete")
    public Object deleteBird(Bird bird, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", bird.getBirdId());
        // 1
        response.setContentType("text/html;charset=utf-8");
        // 2
        PrintWriter out = response.getWriter();

        int deleteid = this.birdService.delete(map);
        out.print(new Gson().toJson(deleteid));
        out.close();
        return null;
    }
    @RequestMapping("deleteBirdSelected")
    public Object deleteBirdSelected(Bird bird, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String [] ids =request.getParameterValues("birdId");
        response.setContentType("text/html;charset=utf-8");
        // 2
        PrintWriter out = response.getWriter();

        int deleteid = this.birdService.delSelected(ids);
        out.print(new Gson().toJson(deleteid));
        out.close();
        return null;
    }
    @RequestMapping("save")
    public void save(@ModelAttribute("bird") Bird bird, HttpServletResponse response) throws Exception {
        // 1
        response.setContentType("text/html;charset=utf-8");
        // 2
        PrintWriter out = response.getWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("bn", bird.getBirdName());
        map.put("ba", bird.getBirdAccount());
        map.put("bp", bird.getBirdPwd());
        out.print(new Gson().toJson(birdService.save(map)));
        System.out.println(map);
        out.close();

    }
}
