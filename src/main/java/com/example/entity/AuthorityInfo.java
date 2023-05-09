package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityInfo {
    private Integer level;
    private String name;
    private List<Model> models;

    public static class Model {
        private Integer modelId;
        private List<Integer> operation;

        public Integer getModelId() {
            return modelId;
        }

        public void setModelId(Integer modelId) {
            this.modelId = modelId;
        }

        public List<Integer> getOperation() {
            return operation;
        }

        public void setOperation(List<Integer> operation) {
            this.operation = operation;
        }
    }
}
