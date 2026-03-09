package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditElementInfoMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface AuditElementInfoMapper {

    /**
     * SELECT 操作: selectAuditElementInfo
     */
    List<AuditElementInfo> selectAuditElementInfo(AuditElementInfo param);

    /**
     * SELECT 操作: selectByAuditModelNumber
     */
    List<AuditElementInfo> selectByAuditModelNumber(String param);

    /**
     * SELECT 操作: selectWriteTime
     */
    String selectWriteTime(String param);

    /**
     * SELECT 操作: selectDockerPhoneByAuditNumnber
     */
    String selectDockerPhoneByAuditNumnber(Integer param);

    /**
     * INSERT 操作: insertAuditElementInfo
     */
    int insertAuditElementInfo(AuditElementInfo param);

    /**
     * UPDATE 操作: updateAuditElementInfostatue1
     */
    int updateAuditElementInfostatue1();

    /**
     * UPDATE 操作: updateAuditElementInfo
     */
    int updateAuditElementInfo();

    /**
     * UPDATE 操作: updateModelEvaluationInfo
     */
    int updateModelEvaluationInfo();

    /**
     * UPDATE 操作: updatedockeMobleByAuditModelNumber
     */
    int updatedockeMobleByAuditModelNumber();

    /**
     * UPDATE 操作: updateModelStepTableModelMsgByModelNumber
     */
    int updateModelStepTableModelMsgByModelNumber(AuditElementInfo param);

    /**
     * UPDATE 操作: updateModelTypeTableByModelNumber
     */
    int updateModelTypeTableByModelNumber(AuditElementInfo param);

}
