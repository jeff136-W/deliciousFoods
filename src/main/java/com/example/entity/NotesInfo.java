package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notes_info")
public class NotesInfo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "time")
	private String time;
	@Column(name = "userId")
	private Long userId;
	@Column(name = "content")
	private String content;
	@Column(name = "status")
	private Integer status;
	@Transient
	private Integer praiseCount;
	@Transient
	private Integer collectCount;

}
