package net.torrypubrepo.simplespring.Services;

/*
 Created by Toriola in 2020
 */

import net.torrypubrepo.simplespring.DataModel.Feeds;
import net.torrypubrepo.simplespring.DataModel.Feeds_CRUD_Interface;
import net.torrypubrepo.simplespring.DbUtil.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;

@Service
public class FeedServices implements Feeds_CRUD_Interface
{
    private static HashMap<Integer, Object> feedMaps = new HashMap<>();

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Override
    public int addNew_Feed(Feeds feeds)
    {
        // Check for null
        if (feeds == null)
            throw new RuntimeException("Post Something Interesting");

        // Perform Db Insert Here
        // Prepare Statement
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String newFeed = "INSERT INTO Feeds(UserId, Title, Content)\n" +
                "VALUES (?,?,?)";
        long id = 0;

        try (Connection connection = dataSourceConfig.getDataSource().getConnection())
        {
            try
            {
                preparedStatement = connection.prepareStatement(newFeed, Statement.RETURN_GENERATED_KEYS);
                // Set Parameters
                preparedStatement.setString(1, feeds.getUserId());
                preparedStatement.setString(2, feeds.getFeedTitle());
                preparedStatement.setString(3, feeds.getFeedContent());

                // Execute Query
                preparedStatement.executeUpdate();

                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    id = resultSet.getLong(1);
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            finally {
                dataSourceConfig.closeResultSetAndPreparedStatement(resultSet, preparedStatement);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return (int)id;

    }//End addNew_Feed(Feeds feeds)

    @Override
    public HashMap<Integer, Object> readAllFeeds()
    {
        Feeds feeds = null;
        int Id = 0;
        String userId = null;   String title = null;
        String content = null;  String postDate = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String getAll_Posts = "SELECT * FROM FEEDS";
        try(Connection connection = dataSourceConfig.getDataSource().getConnection())
        {
            try {
                 // Prepare Statement
                preparedStatement = connection.prepareStatement(getAll_Posts);
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null)
                {
                    while (resultSet.next())
                    {
                        Id = resultSet.getInt(1);
                        userId = resultSet.getNString(2);
                        title = resultSet.getNString(3);
                        content = resultSet.getNString(4);
                        postDate = resultSet.getTimestamp(5).toString();

                        feeds = new Feeds(userId, title, content, postDate);
                        feeds.setId(Id);

                        // Add it to List
                        feedMaps.put(Id, feeds);

                    }//End while

                }

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            finally
            {
                dataSourceConfig.closeResultSetAndPreparedStatement(resultSet, preparedStatement);
            }

        }//End try
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return feedMaps;
    }//End readAllFeeds()

    @Override
    public String findFeed_By_Id(int id)
    {
        Feeds feeds = null;
        int Id = 0;
        String userId = null;   String title = null;
        String content = null;  String postDate = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String find_A_Post = String.format("SELECT * FROM FEEDS WHERE ID = %s", String.valueOf(id));
        try(Connection connection = dataSourceConfig.getDataSource().getConnection())
        {
            try {
                // Prepare Statement
                preparedStatement = connection.prepareStatement(find_A_Post);
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null)
                {
                    if (resultSet.next())
                    {
                        Id = resultSet.getInt(1);
                        userId = resultSet.getNString(2);
                        title = resultSet.getNString(3);
                        content = resultSet.getNString(4);
                        postDate = resultSet.getTimestamp(5).toString();

                        feeds = new Feeds(userId, title, content, postDate);
                        feeds.setId(Id);

                    }//End if

                }//End Outer if

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            finally
            {
                dataSourceConfig.closeResultSetAndPreparedStatement(resultSet,preparedStatement);
            }

        }//End try
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        return feeds.toString();
    }//End findFeed_By_Id

    @Override
    public String updateFeed_By_Id(Feeds feeds)
    {
        return feedMaps.replace(feeds.getId(),feeds).toString();
    }

    @Override
    public String delete_Feed_By_Id(int id) {
        return feedMaps.remove(id).toString();
    }

}//End FeedServices
