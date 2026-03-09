package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditElementSheetPojo;
import com.cxsj.mxzd.pojo.AuditFindDataBase;
import com.cxsj.mxzd.pojo.AuditHandoverModel;
import com.cxsj.mxzd.pojo.ParamData;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditHandoverModelMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface AuditHandoverModelMapper {

    /**
     * SELECT 操作: selectAuditHandoverModel
     */
    List<AuditHandoverModel> selectAuditHandoverModel(AuditHandoverModel param);

    /**
     * SELECT 操作: selectByAuditModelNumber
     */
    List<AuditHandoverModel> selectByAuditModelNumber(ParamData param);

    /**
     * SELECT 操作: selectCenterList
     */
    List<AuditElementInfo> selectCenterList(ParamData param);

    /**
     * SELECT 操作: selectCenterListCount
     */
    Integer selectCenterListCount(ParamData param);

    /**
     * SELECT 操作: selectExcelList
     */
    AuditElementSheetPojo selectExcelList(ParamData param);

    /**
     * SELECT 操作: selectAllPrvd
     */
    Map<String, Object> selectAllPrvd();

    /**
     * SELECT 操作: selectAllModel
     */
    Map<String, Object> selectAllModel(Map<String, Object> param);

    /**
     * INSERT 操作: insertAuditHandoverModel
     */
    int insertAuditHandoverModel(AuditFindDataBase param);

    /**
     * INSERT 操作: inserts
     */
    int inserts(@Param("list") List<AuditHandoverModel> list);

    /**
     * UPDATE 操作: updateAuditHandoverModel
     */
    int updateAuditHandoverModel(AuditHandoverModel param);

    /**
     * UPDATE 操作: deleteByAuditModelNumber
     */
    int deleteByAuditModelNumber(@Param("auditModelNumber") String auditModelNumber);

}
