package com.taotao.service;

import com.taotao.pojo.CatPojo;
import com.taotao.pojo.PageList;
import com.taotao.pojo.TbItem;

import java.util.List;

public interface ItemService {
    public PageList getByListItem(Integer page, Integer rows);

    public List<CatPojo> getCatById(long id);


}