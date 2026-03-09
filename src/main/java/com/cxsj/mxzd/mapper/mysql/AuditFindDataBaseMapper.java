package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.mxzd.pojo.AuditFindDataBase;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditFindDataBaseMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface AuditFindDataBaseMapper {

    /**
     * SELECT 操作: selectAuditFindDataBase
     */
    List<AuditFindDataBase> selectAuditFindDataBase();

    /**
     * SELECT 操作: selectByAuditModelNumber
     */
    List<AuditFindDataBase> selectByAuditModelNumber(String param);

    /**
     * INSERT 操作: insertAuditFindDataBase
     */
    int insertAuditFindDataBase(AuditFindDataBase param);

    /**
     * INSERT 操作: inserts
     */
    int inserts(List param);

    /**
     * UPDATE 操作: updateAuditFindDataBase
     */
    int updateAuditFindDataBase();

    /**
     * UPDATE 操作: deleteByAuditModelNumber
     */
    int deleteByAuditModelNumber();

}
