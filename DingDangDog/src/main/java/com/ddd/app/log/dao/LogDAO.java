package com.ddd.app.log.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ddd.app.log.dto.LogDTO;
import com.ddd.app.util.DBConnector;//db커넥터 안만듬


public class LogDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Properties properties;

	public LogDAO() {
		properties = new Properties();
		try {
			String filePath = "여기에 sql 파일 경로";
			properties.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<LogDTO> selectAll() {
		List<LogDTO> logList = new ArrayList<LogDTO>();

		String query = properties.getProperty("selectAll");

		try {
			connection = DBConnector.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogDTO logDTO = new LogDTO();

				logDTO.setLogNumber(resultSet.getInt("log_number"));
				logDTO.setUserNumber(resultSet.getInt("user_number"));
				logDTO.setLogTitle(resultSet.getString("log_title"));
				logDTO.setLogPost(resultSet.getString("log_post"));
				logDTO.setLogDate(resultSet.getDate("log_date"));
				logDTO.setLogModifyDate(resultSet.getDate("log_modify_date"));

				logList.add(logDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(resultSet, preparedStatement, connection);
		}

		return logList;
	}
}
