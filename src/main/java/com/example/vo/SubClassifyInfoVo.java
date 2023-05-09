package com.example.vo;

import com.example.entity.SubClassifyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubClassifyInfoVo extends SubClassifyInfo {

	private String classifyName;

}