/**
 * 
 */
package com.piggsoft.comms.mybatis.dialect;

/**
 * @author piggsoft
 * @date 2013-5-19 下午1:09:17
 */
public class MySql5Dialect extends Dialect{

	/* (non-Javadoc)
	 * @see com.piggsoft.comm.db.dialect.Dialect#getLimitString(java.lang.String, int, int)
	 */
	@Override
	public String getLimitString(String sql, int skipResults, int maxResults) {
		sql = getLineSql(sql);
		sql = sql.replaceAll("[^\\s,]+\\.", "") + " limit "
					+ skipResults + " ," + maxResults;
		return sql;
	}

	/**
	 * @param sql
	 * @return
	 */
	private String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}

}
