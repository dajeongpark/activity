package com.bora.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bora.page.RowNumber;
import com.bora.util.DBConnector;

public class ReplyDAO {
	
	//selectList(replyList)
	public List<ReplyDTO> selectList(int replyNum) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from (select * from reply where idx=? order by num asc)";
		/*String sql = "select * from "
				+ "(select rownum R, M.* from "
				+ "(select * from reply where idx=? order by num desc) M) "
				+ "where R between ? and ?";*/
		PreparedStatement st = con.prepareStatement(sql);
		RowNumber rowNumber = new RowNumber();
		st.setInt(1, replyNum);
		//st.setInt(2, rowNumber.getStartRow());
		//st.setInt(3, rowNumber.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<ReplyDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			ReplyDTO replyDTO = new ReplyDTO();
			replyDTO.setNum(rs.getInt("num"));
			replyDTO.setWriter(rs.getString("writer"));
			replyDTO.setContents(rs.getString("contents"));
			replyDTO.setReg_date(rs.getDate("reg_date"));
			replyDTO.setIdx(rs.getInt("idx"));
			ar.add(replyDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//insert(replyWrite)
	public int insert(ReplyDTO replyDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into reply values (reply_seq.nextval, 'test', ?, sysdate, ?)";
												//num,writer,contents,reg_date,idx
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, replyDTO.getContents());
		st.setInt(2, replyDTO.getIdx());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//update(replyUpdate)
	
	//delete(replyDelete)
	
	//getCount

}
