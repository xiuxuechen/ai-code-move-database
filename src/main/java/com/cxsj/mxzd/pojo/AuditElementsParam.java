package com.cxsj.mxzd.pojo;


import com.cxsj.mxzd.pojo.spl.ExamineandapproveParam;
import com.cxsj.sup.entity.process.ProBringOneEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

/**
 * lombok注解
 * 审计要素公共入参类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditElementsParam {
    private Integer id;
    //一级业务流程
    private String primaryBusinessProcess;
    //二级业务流程
    private String secondaryBusinessProcess;
    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型编号:
    private String auditModelNumber;

    private List<String> auditModelNumberList;

    //审计模型名称:
    private String auditModelName;
    
    private Boolean isModelingMethod;


    //信息类型：
    private String informationType;

    //审计点业务逻辑
    private String auditBusinessLogic;


    private String executionLogic;  //审计点执行逻辑

    //预期风险/问题发现
    private String expectedRisks;


    private String businessArea;


    private String sourceDomain;


    //预期数据需求
    private String expectedDataRequirements;

    //预期数据覆盖单位需求
    private String expectedDataCoversUnitDemand;

    //其他预期数据覆盖单位需求
    private String otherExpectedDataCoversUnitDemand;

    //预期数据需求涉及系统
    private String requirementsInvolveTheSystem;

    //预期数据需求涉及系统
    private String otherRequirementsInvolveTheSystem;

    //录入完成的信息类型
    private String typeOfInformation;


    //个人中心相关数据
    private PersonalCenter personalCenter;

    //状态
    private String status;

    //模型负责人
    private String modelOwner;


    private String modelOwnerDepy;


    private ProBringOneEntity proBringOneMsg;


    //录入人
    private String dockPeople;
    //填写日期
    private String writeTime;
    //录入人电话
    private String dockPhone;
    //录入人部门
    private String dockDepartment;

    //部分编码
    private String prvdCode;

    //继续录入的阶段
    private String continueToEnter;
    //继续编辑
    private String currentInput;
    //规范要求
    private String codeRequirement;
    //文件名称
    private String fileName;
    //规范要求类型
    private String specificationRequirement;
    //文号
    private String referenceNumber;
    //发文日期
    private String dispatchTime;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;

    //审计模型描述
    private String auditModelDescribe;

    //所属系统(模型评估与已上线模型)
    private String subordinateToSystem;

    //备注
    private String remark;

    //来源
    private String informationSources;
    
    
    //共享单位
    private String shareUnit;
    
    //二级库模型编码
    private String secondModelNumber;
    
    
    private Integer isdel;



    //模型代码(模型评估与已上线模型)
    private String modelCode;
    private AuditHandoverModel  auditHandoverModel;
    private List<AuditFindDataBase> auditFindDataBase;

    //接口返回参数dropdown，查询信息类型下拉
    private String modual;
    private String type;

    //接口返回参数dropdown，查询来源下拉
    private String lymodual;
    private String lytype;

    //接口返回参数dropdown，查询评审下拉
    private String psmodual;
    private String pstype;
    //接口返回参数dropdown，查询进度下拉
    private String jdmodual;
    private String jdtype;

    //接口返回参数dropdown，查询数据范围下拉
    private String sjfwmodual;
    private String sjfwtype;

    //接口返回参数dropdown，查询数据归属域下拉
    private String sjgsymodual;
    private String sjgsytype;

    //接口返回参数dropdown，查询数据接入来源下拉
    private String sjjrlymodual;
    private String sjjrlytype;

    //接口返回参数dropdown，查询数据归属系统拉
    private String sjgsxtmodual;
    private String sjgsxttype;

    //接口返回参数dropdown，数据接入需求的：涉及系统
    private String sjjrxqmodual;
    private String sjjrxqtype;


    //接口返回参数dropdown，数据接入需求的：数据接口名称
    private String sjjkmcmodual;
    private String sjjkmctype;

    //接口返回参数dropdown，数据接入需求的：数据内容描述
    private String sjnrmsmodual;
    private String sjnrmstype;

    //接口返回参数dropdown，数据接入需求的：数据留存周期
    private String sjlczqmodual;
    private String sjlczqtype;


    private String modelTypeExam;

    /*数据能力支撑独有部分入参字段 start ---------**/
    //数据编码
    private String assetCode;
    //对象英文名
    private String dataCode;
    //对象中文名
    private String name;
    //来源系统编码
    private String originalSystemcode;
    //来源系统
    private String originalSystem;
    //接口编码
    private String interId;
    //接口名称
    private String interName;
    //所属层
    private String objLevelCode;
    //业务分类
    private String busiType;
    //数据状态
    private String dataStatus;


    //数据支撑方(总部-省公司)
    private String dataSupporter;
    //是否使用数据资产的数据  1-使用  0-未使用
    private String isAcc;

    //现有数据是否满足模型要求
    private String existingDataOfModel;

    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    private String existingDataOfModelId;

    //数据内容描述(数据接入需求)
    private String dataContentDescriptionXq;
    //涉及系统
    private String involvedSystem;
    //数据范围(数据接入需求)
    private String scopeOfDataXq;
    /*数据能力支撑独有部分入参字段  end---------**/
    //审计模型业务逻辑
    private String auditModelBusinessLogic;

    /*模型评估与开发独有部分入参字段 start ---------**/
    //评估结果
    private String assessmentResult;
    //模型评估备注
    private String modelAssessmentRemarks;
    //部分开发修正后的模型逻辑
    private String modelDevelopmentLogic;
    //后续待开发内容
    private String stayDevelopmentContent;
    //开发进度
    private String progressTheDevelopment;
    //预期完成时间
    private String expectedCompletionTime;
    //尚欠缺条件情况
    private String conditionsStillLacking;
    //模型开发备注
    private String modelDevelopmentRemarks;
    //模型状态
    private String modelState;

    private String modelingMethod;

    //删除状态
    private String isDeleted;

    private String[] ids;

    private String code;
    /*模型评估与开发独有部分入参字段  end---------**/

    /*已上线审计模型独有部分入参字段 start ---------**/
    //业务归属系统
    private String serviceOwnershipSystem;
    //其他业务归属系统
    private String otherServiceOwnershipSystem;
    //数据起始时间
    private String dataStartTime;
    //模型运行频率
    private String modelRunningFrequency;
    //审计覆盖单位数量
    private String numberUnitsCovered;
    //省公司覆盖数量
    private String numberOfProvincial;
    //专业机构数量
    private String numberProfessionalInstitutions;
    //是否已在系统固化
    private String whetherCuredSystem;


    //模型上线时间
    private String modelOnlineTime;
    //审计实务来源
    private String sourcesAuditPractice;
    //归属专题
    private String ascriptionSpecial;
    //备注
    private String onlineRemarks;
    //是否为导入
    private String isImport;

    private String source="zd";

    private String isOnline;
    /*已上线审计模型独有部分入参字段 end ---------**/

    public PersonalCenter getPersonalCenter() {
        personalCenter=new PersonalCenter();
        BeanUtils.copyProperties(this.getClass(), personalCenter);
        return personalCenter;
    }

    private AuditElementInfo auditElementInfo;
    //制度库的实体类
   private List<AuditElementsSystemParam> auditElementsSystemParams;

   //模型评估与开发实体类
    private ModelEvaluationPojo modelEvaluationPojo;
    //已上线审计模型实体类
    private OnlineModelPojo onlineModelPojo;
    //数据支撑能力数据资产管理
    private List<DataSupportInfo> dataSupportInfo;
    //数据能力支撑-数据接入需求
    private List<DataCutInfo> dataCutInfo;

    //设置步骤状态，删除时需要设置此状态，试的查询step表中第三步的数据
    private Integer stepStatus;

    //数据接口名称(现有数据接入情况)
    private String dataInterfaceName;
    //数据接口名称(现有数据接入情况)id
    private String dataInterfaceNameId;
    //审计模型涉及录入人
    private String dockPeople1;
    //审计模型来源信息录入人
    private String dockPeople2;
    //数据支撑能力录入人
    private String dockPeople3;
    //模型评估与开发录入人
    private String dockPeople4;
    //已上线审计模型
    private String dockPeople5;
    //数据能力支撑的备注
    private String dockRemark;
    //数据接口编号
    private String dataInterfaceNumber;
    //问题概要
    private String problemSummary;
    //问题详细描述
    private String problemDescription;
    //审计时间
    private String auditTime;
    //涉及单位
    private String auditInvolved;
    //所属项目
    private String auditProject;
    private String auditPoint;//审计点
    private String auditProspectivePoint;//预期审计发现
    private String auditSystemName;//'审计依据制度名称'
    private String auditSystemContent;//'审计依据制度内容'
    private String auditConfirmationFindings;//'审计发现现场确认情况'
    private String auditModelNameSend;//'模型名称'
    private String auditModelLogic;//'模型逻辑'
    private String supportRemark;//数据支撑备注
    //表英文名（数据内容描述id）data_content_description_id
    private String dataContentDescriptionId;

    private ExamineandapproveParam examineandapproveParam;

    private String isSyn;
    private String synUrl;
    private String defExamUser;

    private String def2ExamUser;

    private String defExamUserDock;

    private String def2ExamUserDepy;


    //模型共享审批人员
    private String shareUser;


    private String shareUserDepy;

    //是否纳入总部模型库
    private String offModelLibrary;

    //是否共享
    private String isShare;


    //状态
    private String offModelLibAndShareType;


    //模型代码id
    private Integer modelCodeFileId;

    //质量评级
    private String qualityRating;

    private String runningMode;


    //审计发现案例
    private List<AuditElementCaseEntity> caseSjs;

    //延伸发现案例
    private List<AuditElementCaseEntity> caseYss;


    private Integer size;

    private Integer page;


    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date detailedTime;
    
    
    private String depmCode;



    private String onlineType;
}
