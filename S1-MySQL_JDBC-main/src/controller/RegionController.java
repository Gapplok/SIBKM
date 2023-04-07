package controller;

import controller.icontroller.IRegionController;
import daos.RegionDAO;
import daos.idoas.IRegionDao;
import java.util.List;
import java.util.stream.Collectors;
import models.Region;
import tools.DBConnection;

public class RegionController implements IRegionController {

  private IRegionDao iRegionDao;
  private DBConnection dbConnection;

  public RegionController(IRegionDao iRegionDao) {
    this.iRegionDao = new RegionDAO(dbConnection.getConnection());
  }

  @Override
  public List<Region> getAll() {
    return iRegionDao.getAll();
  }

  @Override
  public Region getById(String id) {
    Region region = null;
    String result;
    try {
      int idRegion = Integer.parseInt(id);
      Region r = iRegionDao.getById(idRegion);
      if (r == null) {
        result = "Data Region not found!!!";
      } else {
        region = r;
      }
    } catch (Exception e) {
      result = "Error = " + e.getMessage();
    }
    return region;
  }

  @Override
  public List<Region> searchByName(String name) {
    List<Region> regions = iRegionDao
      .getAll()
      .stream()
      .filter(region -> region.getName().contains(name))
      .collect(Collectors.toList());
    return regions;
  }

  @Override
  public List<Region> searchNameByCharacter(String key) {
    return iRegionDao.searchNameByCharacter(key);
  }

  @Override
  public String create(String id, String name, String count) {
    String result = "";
    if (!isNumber(id)) {
      return "Input id must be number!!!";
    } else if (!isLetter(name)) {
      return "Input name must be letter!!!";
    } else if (!isNumber(count)) {
      return "Input count must be number!!!";
    }
    try {
      Region region = new Region(
        Integer.parseInt(id),
        name,
        Integer.parseInt(count)
      );
      region = iRegionDao.save(region);
      if (region != null) {
        result = "Create data Region success...";
      }
    } catch (Exception e) {
      result = "Error = " + e.getMessage();
    }
    return result;
  }

  @Override
  public String update(String id, String name, String count) {
    String result = "";
    if (!isNumber(id)) {
      return "Input id must be number!!!";
    } else if (!isLetter(name)) {
      return "Input name must be letter!!!";
    } else if (!isNumber(count)) {
      return "Input count must be number!!!";
    }
    try {
      Region region = new Region(
        Integer.parseInt(id),
        name,
        Integer.parseInt(count)
      );
      region = iRegionDao.save(region);
      if (region != null) {
        result = "Update data Region success...";
      }
    } catch (Exception e) {
      result = "Error = " + e.getMessage();
    }
    return result;
  }

  @Override
  public String delete(String id) {
    try {
      int idRegion = Integer.parseInt(id);
      Region region = iRegionDao.getById(idRegion);
      if (region == null) {
        return "Data Region not found!!!";
      } else {
        iRegionDao.delete(idRegion);
        return "Delete data region success...";
      }
    } catch (Exception e) {
      return "Error = " + e.getMessage();
    }
  }

  public boolean isNumber(String number) {
    return number.matches("[0-9]*");
  }

  public boolean isLetter(String letter) {
    return letter.matches("[A-Z][a-z]*");
  }
}
