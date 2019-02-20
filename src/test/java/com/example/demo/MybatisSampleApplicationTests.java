package com.example.demo;

import static org.junit.Assert.assertNotNull;

import com.example.demo.mapper.CityMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSampleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CityMapper cityMapper;
    
    /**
     * test insert
     */
    @Test
    @Transactional
    public void findByName() throws Exception {
        cityMapper.insert("MyName", "MyState");
        City city = cityMapper.findByName("MyName");
        Assert.assertEquals("MyName", city.getName());
    }


    /**
     * test update
     * @throws Exception
     */
    @Test
    @Transactional
    public void testUpdate() throws Exception {
        cityMapper.insert("MyName", "MyState");
        cityMapper.update("MyNewName", "MyState");
        City city =cityMapper.findByName("MyNewName");
        Assert.assertNotNull(city);
        Assert.assertEquals("MyNewName", city.getName());
    }


    /**
     * test delete
     */
    @Test
    @Transactional
    public void testDelete(){

        cityMapper.insert("myname", "mystate");
        City city = cityMapper.findByName("myname");
        Assert.assertNotNull(city);
        Assert.assertEquals("myname", city.getName());
        cityMapper.delete("mystate");
        city = cityMapper.findByName("nyname");
        Assert.assertNull(city);

    }

}
