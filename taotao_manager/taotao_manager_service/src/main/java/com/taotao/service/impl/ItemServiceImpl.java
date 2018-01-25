package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public PageList getByListItem(Integer page, Integer rows) {
        if(page==null)page=1;
        if(rows==null)rows=30;
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        PageInfo resoutl = new PageInfo(list);
        PageList pageList = new PageList();
        pageList.setRows(resoutl.getList());
        pageList.setTotal(resoutl.getTotal());
        return pageList;
    }

    @Override
    public List<CatPojo> getCatById(long id) {

        TbItemCatExample example= new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        List<CatPojo> catPojos = new ArrayList<CatPojo>();

        for(TbItemCat tbItemCat : tbItemCats){
            CatPojo catPojo = new CatPojo();
            catPojo.setId(tbItemCat.getId());
            catPojo.setText(tbItemCat.getName());
            catPojo.setState(tbItemCat.getIsParent()?"closed":"open");
            catPojos.add(catPojo);
        }
        return catPojos;
    }


}
