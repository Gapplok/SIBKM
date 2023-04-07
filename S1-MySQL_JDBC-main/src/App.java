import daos.RegionDAO;
import daos.idoas.IRegionDao;
import models.Region;
import tools.DBConnection;

public class App {

  public static void main(String[] args) throws Exception {
    System.out.println();

    DBConnection dbConnection = new DBConnection();
    IRegionDao iRegionDao = new RegionDAO(dbConnection.getConnection());

    // # Test Connection
    System.out.println(dbConnection.getConnection());
    // # Get All Region
    // for (Region region : iRegionDao.getAll()) {
    //   System.out.println(
    //     "Id Region = " +
    //     region.getId() +
    //     ", Name Region = " +
    //     region.getName() +
    //     ", Count = " +
    //     region.getCount()
    //   );
    // }

    // # Create Region
    // Region region = new Region(5, "Australia", 2);
    // System.out.println(iRegionDao.create(region));
  }
}
// Create Project VSCode = ctrl + shift + p
