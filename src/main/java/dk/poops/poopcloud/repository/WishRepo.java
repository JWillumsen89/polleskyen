package dk.poops.poopcloud.repository;

import dk.poops.poopcloud.models.Wish;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class WishRepo {

    public void reserveWish(Wish wish) {


        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://poopserver.mysql.database.azure.com/pooporganizer",
                    "poop",
                    "pollerne_1");
            String queryCreate = "UPDATE wishes SET reserved = ? WHERE id =?";
            PreparedStatement psts = conn.prepareStatement(queryCreate);


            /*ResultSet rs = psts.executeQuery();

            rs.next();
            boolean reserved = rs.getBoolean(2);
            wish.setReserved(reserved);*/


            if (wish.isReserved()){
                psts.setBoolean(1, false );
            } else {
                psts.setBoolean(1, true);
            }
            psts.setInt(2, wish.getId());


            //Execute query
            psts.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Can't connect to database");
            e.printStackTrace();
        }

    }
}
