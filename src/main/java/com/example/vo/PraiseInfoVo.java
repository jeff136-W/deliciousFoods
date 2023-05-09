package com.example.vo;

import com.example.entity.PraiseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraiseInfoVo extends PraiseInfo {

	private String notesName;

}