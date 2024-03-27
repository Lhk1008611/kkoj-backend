package com.lhk.kkoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lhk.kkoj.mapper.QuestionMapper;
import com.lhk.kkoj.model.entity.Question;
import com.lhk.kkoj.service.QuestionService;
import org.springframework.stereotype.Service;

/**
* @author Lhk
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-03-27 20:27:18
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

}




