package com.example.vo;

import com.example.entity.CollectInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectInfoVo extends CollectInfo {

	private String foodsName;

}