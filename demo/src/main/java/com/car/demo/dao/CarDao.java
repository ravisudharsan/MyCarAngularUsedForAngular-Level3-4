package com.car.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.car.demo.model.Car;

@Repository
public class CarDao {

	@Autowired
	JdbcTemplate jd;
	
	public List<Car> getall()
	{
		List<Car> li=new ArrayList<>();
		jd.query("select id,carname,model from cartable", new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				li.add(new Car(rs.getInt("id"),rs.getString("carname"),rs.getString("model")));
			}
		});
		return li;
	}
	
	public int addCar(String name,String model) {
		String query="insert into cartable(carname,model)values(?,?)";
		return jd.update(query,name,model);
	}
}
