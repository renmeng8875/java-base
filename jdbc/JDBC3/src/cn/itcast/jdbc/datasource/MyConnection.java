package cn.itcast.jdbc.datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * 2008-12-13
 * 
 * @author <a href="mailto:liyongibm@gmail.com">liyong</a>
 * 
 */
public class MyConnection implements Connection {
	private Connection realConnection;
	private MyDataSource2 dataSource;
	private int maxUseCount = 5;
	private int currentUserCount = 0;

	MyConnection(Connection connection, MyDataSource2 dataSource) {
		this.realConnection = connection;
		this.dataSource = dataSource;
	}

	public void clearWarnings() throws SQLException {
		this.realConnection.clearWarnings();
	}

	public void close() throws SQLException {
		this.currentUserCount++;
		if (this.currentUserCount < this.maxUseCount)
			this.dataSource.connectionsPool.addLast(this);
		else {
			this.realConnection.close();
			this.dataSource.currentCount--;
		}
	}

	public void commit() throws SQLException {
		this.realConnection.commit();
	}

	public Statement createStatement() throws SQLException {
		return this.realConnection.createStatement();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return null;
	}

	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return null;
	}

	public boolean getAutoCommit() throws SQLException {
		return false;
	}

	public String getCatalog() throws SQLException {
		return null;
	}

	public int getHoldability() throws SQLException {
		return 0;
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return null;
	}

	public int getTransactionIsolation() throws SQLException {
		return 0;
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return null;
	}

	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	public boolean isClosed() throws SQLException {
		return false;
	}

	public boolean isReadOnly() throws SQLException {
		return false;
	}

	public String nativeSQL(String sql) throws SQLException {
		return null;
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		return null;
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return null;
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		return null;
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return null;
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {

	}

	public void rollback() throws SQLException {

	}

	public void rollback(Savepoint savepoint) throws SQLException {

	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {

	}

	public void setCatalog(String catalog) throws SQLException {

	}

	public void setHoldability(int holdability) throws SQLException {

	}

	public void setReadOnly(boolean readOnly) throws SQLException {

	}

	public Savepoint setSavepoint() throws SQLException {
		return null;
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		return null;
	}

	public void setTransactionIsolation(int level) throws SQLException {

	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return null;
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		return false;
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

}
