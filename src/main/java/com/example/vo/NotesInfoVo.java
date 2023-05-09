package com.example.vo;

import com.example.entity.NotesInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesInfoVo extends NotesInfo {

	private String userName;

}