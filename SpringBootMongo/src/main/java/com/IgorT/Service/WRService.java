package com.IgorT.Service;

import com.IgorT.Dao.SafariDao;
import com.IgorT.Entity.SafariCntry;
import com.IgorT.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WRService {
    @Autowired

    @Qualifier("mysqlSafariData")

    private SafariDao safariDao;

    public void updateSafari(Integer ordNo, String name)
    {
        safariDao.updateSafari( ordNo,  name);
    }

    public  Collection<SafariCntry> getAllSafariCnt()
    {
        return safariDao.getAllSafariCnt();
    }
}
