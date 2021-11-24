package x.x.swagger.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 学生实体类
 */
@ApiModel(value = "学生实体类")
@Data
@AllArgsConstructor
public class Student {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
