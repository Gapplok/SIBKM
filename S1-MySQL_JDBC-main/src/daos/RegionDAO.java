package daos;

import daos.idoas.IRegionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

public class RegionDAO implements IRegionDao {

  private Connection connection;

  public RegionDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Region> getAll() {
    List<Region> regions = new ArrayList<>();
    String query = "SELECT * FROM REGION";

    try {
      ResultSet resultset = connection.prepareStatement(query).executeQuery();
      while (resultset.next()) {
        Region region = new Region(
          resultset.getInt(1),
          resultset.getString(2),
          resultset.getInt(3)
        );

        // Region region = new Region();
        // region.setId(resultset.getInt(1));
        // region.setName(resultset.getString(2));
        // region.setCount(resultset.getInt(3));

        regions.add(region);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return regions;
  }

  @Override
  public Region getById(int id) {
    Region region = new Region();
    String query = "SELECT * FROM REGION WHERE id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        region =
          new Region(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getInt(3)
          );
      }
    } catch (Exception e) {
      // e.printStackTrace();
      System.out.println("Error = " + e.getMessage());
    }
    return region;
  }

  @Override
  public List<Region> searchNameByCharacter(String key) {
    List<Region> regions = new ArrayList<>();
    Region region = new Region();
    String query =
      "SELECT * FROM REGION WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, "%" + key + "%");
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        region =
          new Region(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getInt(3)
          );
        regions.add(region);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return regions;
  }

  // create or update
  @Override
  public Region save(Region r) {
    Region region = getById(r.getId());
    String query = (region == null)
      ? "INSERT INTO REGION(name, count, id) VALUES(?,?,?)"
      : "UPDATE REGION SET name = ?, count = ? WHERE id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, r.getName());
      preparedStatement.setInt(2, r.getCount());
      preparedStatement.setInt(3, r.getId());
      region = r;
    } catch (Exception e) {
      System.out.println("Error = " + e.getMessage());
      region = null;
    }
    return region;
  }

  @Override
  public void delete(int id) {
    String query = "DELETE FROM REGION WHERE id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
      System.out.println(
        "Data Region with id = " + id + " success to delete..."
      );
    } catch (Exception e) {
      System.out.println("Error = " + e.getMessage());
    }
  }
}
