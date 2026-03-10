package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.common.dto.ModelOrderParam;
import com.cxsj.mxzd.pojo.ASuppInParam;
import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditElementsEmpty;
import com.cxsj.mxzd.pojo.AuditElementsParam;
import com.cxsj.mxzd.pojo.DataSupportInfo;
import com.cxsj.mxzd.pojo.spl.ExamineandapproveParam;
import com.cxsj.mxzd.pojo.ExportDateSupportExcel;
import com.cxsj.mxzd.pojo.ModAssetsParam;
import com.cxsj.mxzd.pojo.ModelAssetsPojo;
import com.cxsj.mxzd.pojo.SupportInCutInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * DataSupportCapabilityMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface MysqlDataSupportCapabilityMapper {

    /**
     * SELECT 操作: getOrderModelMsgByModelNumber
     */
    ModelOrderParam getOrderModelMsgByModelNumber(String param);

    /**
     * SELECT 操作: selectSupportList
     */
    List<AuditElementsEmpty> selectSupportList(AuditElementsParam param);

    /**
     * SELECT 操作: selectSupportListCount
     */
    Integer selectSupportListCount(AuditElementsParam param);

    /**
     * SELECT 操作: getdataSupportList
     */
    ExportDateSupportExcel getdataSupportList(AuditElementsParam param);

    /**
     * SELECT 操作: getDropdownAuditPointName
     */
    Map getDropdownAuditPointName(Map param);

    /**
     * SELECT 操作: getDropdownAuditModelName
     */
    Map getDropdownAuditModelName(Map param);

    /**
     * SELECT 操作: selectModelNameToPointName
     */
    Map selectModelNameToPointName(List param);

    /**
     * SELECT 操作: selectGlMsg
     */
    ASuppInParam selectGlMsg(String param);

    /**
     * SELECT 操作: getdataDockPeopleList
     */
    Map getdataDockPeopleList(Map param);

    /**
     * SELECT 操作: getDropdownboxNo1TableNew
     */
    Map getDropdownboxNo1TableNew(Map param);

    /**
     * SELECT 操作: getDropdownboxMo2TableNew
     */
    Map getDropdownboxMo2TableNew(Map param);

    /**
     * SELECT 操作: selectByAuditModelNumberSupport
     */
    List<AuditElementInfo> selectByAuditModelNumberSupport(AuditElementsParam param);

    /**
     * SELECT 操作: selectByAuditModelNumberSupportzichan
     */
    List<DataSupportInfo> selectByAuditModelNumberSupportzichan(AuditElementsParam param);

    /**
     * SELECT 操作: selectByAuditModelNumberSupportzichanAscTime
     */
    List<DataSupportInfo> selectByAuditModelNumberSupportzichanAscTime(AuditElementsParam param);

    /**
     * SELECT 操作: selectAllDataSupport
     */
    DataSupportInfo selectAllDataSupport();

    /**
     * SELECT 操作: getinterfaceNumberList
     */
    Map getinterfaceNumberList(AuditElementsParam param);

    /**
     * SELECT 操作: getdataContentDescriptionList
     */
    Map getdataContentDescriptionList(AuditElementsParam param);

    /**
     * SELECT 操作: getscopeOfDataList
     */
    Map getscopeOfDataList(AuditElementsParam param);

    /**
     * SELECT 操作: gedataDomainList
     */
    Map gedataDomainList(AuditElementsParam param);

    /**
     * SELECT 操作: getstructuredDataNotIdList
     */
    String getstructuredDataNotIdList(AuditElementsParam param);

    /**
     * SELECT 操作: getdataRetentionCycleList
     */
    Map getdataRetentionCycleList(AuditElementsParam param);

    /**
     * SELECT 操作: getdataAccesstimeList
     */
    String getdataAccesstimeList(AuditElementsParam param);

    /**
     * SELECT 操作: getdataAttributionSystemList
     */
    Map getdataAttributionSystemList(AuditElementsParam param);

    /**
     * SELECT 操作: selectSupportInCutById
     */
    List<SupportInCutInfo> selectSupportInCutById(SupportInCutInfo param);

    /**
     * SELECT 操作: selectAssCodeList
     */
    Map selectAssCodeList(AuditElementsParam param);

    /**
     * SELECT 操作: selectDataCodeList
     */
    Map selectDataCodeList(AuditElementsParam param);

    /**
     * SELECT 操作: selectNameList
     */
    Map selectNameList(AuditElementsParam param);

    /**
     * SELECT 操作: selectSourceSys
     */
    Map selectSourceSys();

    /**
     * SELECT 操作: selectOriginalSystemcodeList
     */
    Map selectOriginalSystemcodeList(AuditElementsParam param);

    /**
     * SELECT 操作: selectOriginalSystemList
     */
    Map selectOriginalSystemList(AuditElementsParam param);

    /**
     * SELECT 操作: selectInterIdList
     */
    Map selectInterIdList(AuditElementsParam param);

    /**
     * SELECT 操作: selectInterNameList
     */
    Map selectInterNameList(AuditElementsParam param);

    /**
     * SELECT 操作: selectObjLevelCodeList
     */
    Map selectObjLevelCodeList(AuditElementsParam param);

    /**
     * SELECT 操作: selectBusiTypeList
     */
    Map selectBusiTypeList(AuditElementsParam param);

    /**
     * SELECT 操作: selectDataStatusList
     */
    Map selectDataStatusList(AuditElementsParam param);

    /**
     * SELECT 操作: selectAuditModelAssets
     */
    List<ModelAssetsPojo> selectAuditModelAssets(ModAssetsParam param);

    /**
     * SELECT 操作: selectAccessMsg
     */
    DataSupportInfo selectAccessMsg(Map param);

    /**
     * SELECT 操作: selectDropIds
     */
    String selectDropIds(ExamineandapproveParam param);

    /**
     * INSERT 操作: insertAuditSupportDataBase
     */
    int insertAuditSupportDataBase(DataSupportInfo param);

    /**
     * INSERT 操作: insertAllDataSup
     */
    int insertAllDataSup(Map param);

    /**
     * INSERT 操作: insertsuportList
     */
    int insertsuportList(List param);

    /**
     * INSERT 操作: insertcutList
     */
    int insertcutList(List param);

    /**
     * INSERT 操作: inertAessData
     */
    int inertAessData(Map param);

    /**
     * UPDATE 操作: deleteByAuditModelNumber
     */
    int deleteByAuditModelNumber();

    /**
     * UPDATE 操作: updateAuditElementInfo
     */
    int updateAuditElementInfo(AuditElementsParam param);

    /**
     * UPDATE 操作: updateAuditSupportDataBase
     */
    int updateAuditSupportDataBase(DataSupportInfo param);

    /**
     * UPDATE 操作: updateAuditSupportDeleteStatus
     */
    int updateAuditSupportDeleteStatus(AuditElementsParam param);

    /**
     * DELETE 操作: deleteGlMsg
     */
    int deleteGlMsg(Map param);

    /**
     * DELETE 操作: trunAessesData
     */
    int trunAessesData();

    /**
     * DELETE 操作: deleteDataSupportData
     */
    int deleteDataSupportData();

    /**
     * DELETE 操作: deleteAllModelMsg
     */
    int deleteAllModelMsg(ExamineandapproveParam param);

}
