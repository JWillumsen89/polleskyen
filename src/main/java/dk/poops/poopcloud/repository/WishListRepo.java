package dk.poops.poopcloud.repository;

import dk.poops.poopcloud.models.Wish;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class WishListRepo {

    public void deleteWishList(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://poopserver.mysql.database.azure.com/pooporganizer",
                    "poop",
                    "pollerne_1");
            String queryCreate = "DELETE FROM wishes WHERE list_id =?";
            PreparedStatement psts = conn.prepareStatement(queryCreate);

            //Insert name and price in prepared statement.
            psts.setInt(1, id);

            //Execute query
            psts.executeUpdate();

            queryCreate = "DELETE FROM wishlist WHERE id =?";
            psts = conn.prepareStatement(queryCreate);

            //Insert name and price in prepared statement.
            psts.setInt(1, id);

            //Execute query
            psts.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Can't connect to database");
            e.printStackTrace();
        }
    }


}
