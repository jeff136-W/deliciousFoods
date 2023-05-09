package com.example.vo;

import com.example.entity.FoodsMenuInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodsMenuInfoVo extends FoodsMenuInfo {

	private String subName;
	private Integer praiseCount;
	private Integer collectCount;

}
