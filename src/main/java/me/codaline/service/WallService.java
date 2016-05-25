package me.codaline.service;

import me.codaline.dao.WallDao;
import me.codaline.model.WallEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yurik on 25.05.16.
 */
@Service
public class WallService {

    @Autowired
    WallDao wallDao;

    public void saveEntry(WallEntry entry){
        wallDao.saveWallEntry(entry);
    }

    public List<WallEntry> getListWallEntries(int id){
        return wallDao.getEntries(id);
    }
}
