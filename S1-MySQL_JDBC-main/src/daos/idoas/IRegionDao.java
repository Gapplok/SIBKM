package daos.idoas;

import java.util.List;
import models.Region;

public interface IRegionDao {
  public List<Region> getAll();

  public Region getById(int id);

  public List<Region> searchNameByCharacter(String key); // search by key

  public Region save(Region r); // create & update

  public void delete(int id);
}
