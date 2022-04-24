package com.education.study.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(example = "사용자이름")
    private String userName;

    @ApiModelProperty(example = "사용자이메일")
    private String userEmail;

    @ApiModelProperty(example = "사용자전화번호")
    private String userPhone;

    @ApiModelProperty(example = "사용자 비밀번호")
    private String userPwd;

    @ApiModelProperty(example = "사용자닉네임")
    private String userNickName;

    @ApiModelProperty(example = "사용자성별")
    private String userGender;

    @ApiModelProperty(example = "사용자생년월일")
    private String userBirth;

    @JsonIgnore
    @ApiModelProperty(example = "사용자No")
    private Integer userNo;

}