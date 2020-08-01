package edu.lin.emp.service.impl;

import edu.lin.emp.dao.BirdMapper;
import edu.lin.emp.entity.Bird;
import edu.lin.emp.service.BirdService;
import edu.lin.emp.util.Env;
import edu.lin.emp.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lin
 * @time: 2020/7/31 19:16
 */
@Service
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdMapper birdMapper;
   /* @Override
    public List<Bird> birdList() {
        return birdMapper.birdList();
    }*/

    @Override
    public int login(Map<String, Object> params) {
        return birdMapper.login(params);
    }

    @Override
    public Pager<Bird> loadUsersListPager(int currentPage) {
        // 获取表中全部数据传递给Pager对象的list属性
        // 查询全部用户信息
        List<Bird> users = this.birdMapper.birdList();
        // 获取配置文件中几条一页
        Integer pageSize = Integer.parseInt(Env.getInstance().getProperty(
                "pageSize"));
        //创建Pager对象
        Pager<Bird> pageInfo = new Pager<>(users.size(), currentPage, pageSize);

        // 判断是否是最后一页,如果最后一页就显示最后一页的几条数据，不是最后一页就显示pageSize条
        if (currentPage == pageInfo.getTotalPage())
            /////////////////////
            pageInfo.setList(users.subList((currentPage - 1) * pageSize,
                    users.size()));
        else
            pageInfo.setList(users.subList((currentPage - 1) * pageSize,
                    (currentPage - 1) * pageSize + pageSize));
        return pageInfo;
    }

    @Override
    public int delete(Map<String, Object> params) {
        return birdMapper.delete(params);
    }

    @Override
    public int delSelected(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                birdMapper.delete(Integer.parseInt(id));
            }
        }
        return 0;
    }

    @Override
    public int save(Map<String, Object> params) {
        return birdMapper.save(params);
    }
}
