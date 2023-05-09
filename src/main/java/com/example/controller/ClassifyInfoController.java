package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.ClassifyInfo;
import com.example.service.*;
import com.example.vo.ClassifyInfoVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/classifyInfo")
public class ClassifyInfoController {
    @Autowired
    private ClassifyInfoService classifyInfoService;

    @PostMapping
    public Result<ClassifyInfo> add(@RequestBody ClassifyInfoVo classifyInfo) {
        classifyInfoService.add(classifyInfo);
        return Result.success(classifyInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        classifyInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ClassifyInfoVo classifyInfo) {
        classifyInfoService.update(classifyInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<ClassifyInfo> detail(@PathVariable Long id) {
        ClassifyInfo classifyInfo = classifyInfoService.findById(id);
        return Result.success(classifyInfo);
    }

    @GetMapping
    public Result<List<ClassifyInfoVo>> all() {
        return Result.success(classifyInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<ClassifyInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(classifyInfoService.findPage(name, pageNum, pageSize, request));
    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<ClassifyInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(ClassifyInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<ClassifyInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getName())).collect(Collectors.toList());
            for (ClassifyInfo info : resultList) {
                classifyInfoService.add(info);
            }
        }
        return Result.success();
    }

    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("name", "");
		row.put("descroiption", "");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=classifyInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
}
