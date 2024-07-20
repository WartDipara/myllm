package com.ela.myLLM.mapper;

import com.ela.myLLM.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("INSERT INTO records " +
            "VALUES(default,#{r.userId},#{r.token},now(),#{r.pay},#{r.question},#{r.response})")
    Integer insert(@Param("r")Record record);


    @Select("SELECT rec_id as id,rec_user_id as user_id, rec_token as token," +
            "rec_time as oprtime,rec_pay as pay,user_nickname as userNickname,rec_ask as question,rec_response as response " +
            "FROM records rt " +
            "JOIN users ut " +
            "ON rt.rec_user_id=ut.user_id " +
            "WHERE rec_user_id=#{uid} " +
            "order by rec_time")
    List<Record> selectByUser(@Param("uid") Integer userId);



    @Select("select count(*) from records where rec_user_id=#{uId} and to_days(rec_time)=to_days(#{day})")
    Integer selectCountByDate(@Param("day")Date day,@Param("uId")Integer userId);
}
