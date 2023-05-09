package com.example.vo;

import com.example.entity.NotesInfoComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesInfoCommentVo extends NotesInfoComment {

    private String foreignName;

}