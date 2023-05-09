package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "praise_info")
public class PraiseInfo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "time")
	private String time;
	@Column(name = "notesId")
	private Long notesId;
	@Column(name = "foodsId")
	private Long foodsId;
	@Column(name = "userId")
	private Long userId;
	private Integer level;

}
