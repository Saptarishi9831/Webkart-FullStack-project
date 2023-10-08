package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//SecurityConfig.java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
.antMatchers("/register", "/login","/createCategories","/getAllCategories","/getCategoryById/{categoryid}","/updateCategory/{categoryid}","/deleteCategory/{categoryid}","/createSubCategories","/getAllSubCategories","/getSubCategoryById/{subCategoryId}","/updateSubCategory/{subCategoryId}","/deleteSubCategory/{subCategoryId}","/setCategoryidToSubCategory/{subCategoryId}/{categoryid}","/setsubcategoryidToSubSubCategory/{subSubCategoryId}/{subcategoryid}","/createSubSubCategories","/getAllSubSubCategories","/getSubSubCategoryById/{subSubCategoryId}","/deleteSubSubCategory/{subSubCategoryId}","/createFourthLevelCategories","/getAllFourthLevelCategories","/getFourthLevelCategoryById/{fourthlevelcategoryId}","/deleteFourthLevelCategory/{fourthlevelcategoryId}","/uploadImage","/getAllFourthCategoryImage","/getAllFourthCategoryImageById/{imageFourthId}","/updateImageFourthCategory/{imageFourthId}","/deleteImageFourthCategory/{imageFourthId}","/setFourthCategoryidToImageCategory/{imageFourthId}/{fourthlevelcategoryId}","/addProduct","/getAllProduct","/getProductById/{productId}","/deleteProduct/{productId}","/setUseridToProduct/{productId}/{id}","/search","/add","/{userId}","/adminLogin","/addAdmin","/getAdminByusername/{username}/{password}","/updateSubSubCategory/{subSubCategoryId}/{categoryid}/{subcategoryId}","/updateFourthLevelCategory/{fourthlevelcategoryId}/{categoryid}/{subcategoryId}/{subSubCategoryId}","/updateProduct/{productId}/{fourthlevelcategoryId}/{categoryid}/{subcategoryId}/{subSubCategoryId}","/subcategories/{categoryid}","/subcategories/{subcategoryId}/subsubcategories","/subsubcategories/{subSubCategoryId}/fourthlevelcategories").permitAll()
.anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}


