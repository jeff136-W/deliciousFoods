package com.example.vo;

import com.example.entity.ClassifyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassifyInfoVo extends ClassifyInfo {

    List<SubClassifyInfoVo> subList;

}
