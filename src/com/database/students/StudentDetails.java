package com.database.students;


public class StudentDetails {
      private Integer id;
        private String name;
        private Integer age;

        public StudentDetails() {

        }

        public StudentDetails(int id , String name) {
            this.name = name;
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
        }

    }
