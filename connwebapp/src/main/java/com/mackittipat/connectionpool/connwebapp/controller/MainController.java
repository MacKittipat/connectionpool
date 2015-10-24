package com.mackittipat.connectionpool.connwebapp.controller;

import com.mackittipat.connectionpool.connwebapp.dao.ItemDao;
import com.mackittipat.connectionpool.connwebapp.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MainController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value = "/save")
    public String save() {

        Random rand = new Random();
        int num = rand.nextInt(100) + 1;

        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(num + "");
        itemDao.save(itemModel);

        return "Saved. id=" + itemModel.getId() + ", title=" + itemModel.getTitle();
    }
}
