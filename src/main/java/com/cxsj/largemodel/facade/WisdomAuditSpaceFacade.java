package com.cxsj.largemodel.facade;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Data;

/**
 * @Author: xxc
 * @Date: 2023/2/10 15:42
 */
@Data
public class WisdomAuditSpaceFacade {

    /**
     * 主键ID
     */
    @ExcelIgnore
    private Integer id;
}
