package com.IgorT.Dao;

import com.IgorT.Entity.SafariCntry;

import java.util.Collection;

public interface SafariDao {



    void updateSafari(Integer ordNo, String name);
    Collection<SafariCntry>getAllSafariCnt();
}
