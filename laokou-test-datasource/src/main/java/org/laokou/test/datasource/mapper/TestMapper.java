package org.laokou.test.datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.laokou.test.datasource.entity.TestEntity;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper extends BaseMapper<TestEntity> {
}
