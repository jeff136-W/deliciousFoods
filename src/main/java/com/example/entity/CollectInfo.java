package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "collect_info")
public class CollectInfo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "time")
	private String time;
	@Column(name = "foodsId")
	private Long foodsId;
	@Column(name = "notesId")
	private Long notesId;
	@Column(name = "userId")
	private Long userId;
	private Integer level;
}
