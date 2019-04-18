package com.zxx.hmy520.graduationdesign.base.mysql.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * jackson 基础数据过滤,只过滤BaseModel类中的字段
     *
     * @author kam
     */
    public interface BaseView {
    }

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    @JsonView({BaseView.class})
    protected Long id;
}
