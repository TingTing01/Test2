package com.tourcan.att.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

@SuppressWarnings("unused")
public class AttDAO implements AttDAO_interface {
//
//	// Ver.JDBC
////	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
////	private static final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Tourcan";
////	private static final String userid = "sa";
////	private static final String passwd = "P@ssw0rd";
//
	private static int STMT_SHIFT = 0; // 1 for JDBC, 0 for Hibernate
//
//	// SQL statements
//	private static final String INSERT_STMT = "INSERT INTO att ( "
//			+ "att_name, att_staytime, region_id, att_addr, att_price, att_phone, att_url, att_eat, att_intro, att_open, att_lat, att_lng ) "
//			+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
//	private static final String GET_ALL_STMT = "SELECT "
//			+ "att_name, att_staytime, region_id, att_addr, att_price, att_phone, att_url, att_eat, att_intro, att_open, att_lat, att_lng, att_id "
//			+ "FROM att order by att_id";
//	private static final String GET_BY_ID_STMT = "SELECT "
//			+ "att_name, att_staytime, region_id, att_addr, att_price, att_phone, att_url, att_eat, att_intro, att_open, att_lat, att_lng, att_id "
//			+ "FROM att where att_id = ?";
//	private static final String GET_BY_NAME_STMT = "SELECT "
//			+ "att_name, att_staytime, region_id, att_addr, att_price, att_phone, att_url, att_eat, att_intro, att_open, att_lat, att_lng, att_id "
//			+ "FROM att where att_name like ?";
//	private static final String DELETE_STMT = "DELETE FROM att where att_id = ?";
//	private static final String UPDATE_STMT = "UPDATE att set "
//			+ "att_name=?, att_staytime=?, region_id=?, att_addr=?, att_price=?, att_phone=?, att_url=?, att_eat=?, att_intro=?, att_open=?, att_lat=?, att_lng=? "
//			+ "where att_id = ?";
//
//	
	@Override
	public AttVO findById(Integer att_id) {
		AttVO attVO=null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			attVO=(AttVO) session.get(AttVO.class,att_id );
			session.beginTransaction().commit();
		} catch (RuntimeException e) {
			session.beginTransaction().rollback();
			throw e;
			
		}
		return attVO;

	}

	@Override
	public List<AttVO> findByName(String att_name) {
		List<AttVO> name=null;
	    
    	List<String> attname=null;
    	Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query= session.createSQLQuery("select att_name from att");
		
		
			query.setString(0, att_name);
			name=query.list();	
			
//			for( List<AttVO> attVO :attname){			
//				name=attVO;
//			}
			session.beginTransaction().commit();

			} catch (RuntimeException e) {
				session.beginTransaction().rollback();
				throw e;
				
			}
			return name;
	}

	@Override
	public List<AttVO> getAll() {
		List<AttVO> list =null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();

    	try {
			session.beginTransaction();
			Query query =session.createQuery("from AttVO order by att_id");
			list=query.list();
			session.beginTransaction().commit();
		} catch (RuntimeException e) {
			session.beginTransaction().rollback();
			throw e;
			
		}
		return list;
	}
//
//	public static void main(String[] args) {
//		// findByIdTest();
//		// findByNameTest();
//		getAllTest();
//		// dumpFileToDB();
//	}
//
//	private static void findByIdTest() {
//		AttDAO dao = new AttDAO();
//		for (int id : new int[] { 1196, 1198, 1219, 1242, 1254 }) {
//			AttVO att = dao.findById(id);
//			System.out.println("--------------" + att.getAtt_id() + "--------------");
//			System.out.println(att.getAtt_name());
//			System.out.println(att.getAtt_phone());
//			System.out.println(att.getAtt_price());
//			System.out.println(att.getAtt_eat() ? "吃貨です" : "吃貨じゃない");
//			System.out.println(att.getAtt_url());
//			System.out.println(att.getAtt_intro());
//		}
//
//	}
//
//	private static void findByNameTest() {
//		AttDAO dao = new AttDAO();
//		for (AttVO att : dao.findByName("%清境%")) {
//			System.out.println("--------------" + att.getAtt_id() + "--------------");
//			System.out.println(att.getAtt_name());
//			System.out.println(att.getAtt_phone());
//			System.out.println(att.getAtt_price());
//			System.out.println(att.getAtt_eat() ? "吃貨です" : "吃貨じゃない");
//			System.out.println(att.getAtt_url());
//			System.out.println(att.getAtt_intro());
//		}
//	}
//
//	private static void getAllTest() {
//		AttDAO dao = new AttDAO();
//		for (AttVO att : dao.getAll()) {
//			System.out.println("--------------" + att.getAtt_id() + "--------------");
//			System.out.println(att.getAtt_name());
//			System.out.println(att.getAtt_phone());
//			System.out.println(att.getAtt_price());
//			System.out.println(att.getAtt_eat() ? "吃貨です" : "吃貨じゃない");
//			System.out.println(att.getAtt_url());
//			System.out.println(att.getAtt_intro());
//		}
//	}
//
//	private static void dumpFileToDB() {
//		AttDAO dao = new AttDAO();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		InputStream is = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
//
//		String line = null;
//		int count = 0;
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userid, passwd);
//			pstmt = conn.prepareStatement(INSERT_STMT);
//
//			is = new FileInputStream("E:/att.csv");
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);
//
//			conn.setAutoCommit(false);
//			while ((line = br.readLine()) != null) {
//				if (count++ < 1)
//					continue;
//				if (count > 72)
//					break;
//
//				// System.out.println(line);
//				String[] vars = line.concat(",EOF").split(",");
//				AttVO att = new AttVO();
//				for (int i = 0; i < vars.length; i++) {
//					vars[i] = vars[i].trim();
//					vars[i] = "".equalsIgnoreCase(vars[i]) ? null : vars[i];
//					vars[i] = "null".equalsIgnoreCase(vars[i]) ? null : vars[i];
//				}
//				// System.out.print(vars.length);
//				// System.out.print('\n');
////				att.setAtt_area(vars[0] == null ? null : Integer.valueOf(vars[0]));
//				att.setAtt_name(vars[1] == null ? null : String.valueOf(vars[1]));
//				// att.setAtt_id(Integer.valueOf(vars[2]));
//				att.setAtt_staytime(vars[3] == null ? null : Integer.valueOf(vars[3]));
//				att.setRegion_id(vars[4] == null ? null : Integer.valueOf(vars[4]));
//				att.setAtt_addr(String.valueOf(vars[5]));
//				att.setAtt_price(vars[6] == null ? null : Double.valueOf(vars[6]));
//				att.setAtt_phone(vars[7] == null ? null : String.valueOf(vars[7]));
//				att.setAtt_url(vars[8] == null ? null : String.valueOf(vars[8]));
//				att.setAtt_eat(Boolean.valueOf(vars[9]));
//				att.setAtt_intro(vars[10] == null ? null : String.valueOf(vars[10]));
//				att.setAtt_open(vars[11] == null ? null : String.valueOf(vars[11]));
//
//				dao.insert(att);
//			}
//			pstmt.executeBatch();
//			conn.commit();
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//			System.out.println("ERROR @ count = " + count);
//			System.out.println(line);
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (br != null)
//					br.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (isr != null)
//					isr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (is != null)
//					is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	@Override
	public void insert(AttVO attVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AttVO attVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AttVO attVO) {
		// TODO Auto-generated method stub
		
	}
}
