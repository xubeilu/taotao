package com.taotao.service;

import com.taotao.pojo.CatPojo;
import com.taotao.pojo.PageList;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    private PageList getItemPage(Integer page,Integer rows){
        return itemService.getByListItem(page,rows);
    }

    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public  List<CatPojo> getCatList(@RequestParam(value = "id",defaultValue = "0") long parentId){
        List<CatPojo> list = itemService.getCatById(parentId);
        return list;
    }
}
