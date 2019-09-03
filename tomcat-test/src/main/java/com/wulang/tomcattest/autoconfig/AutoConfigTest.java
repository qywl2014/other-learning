package com.wulang.tomcattest.autoconfig;

import com.wulang.tomcattest.domain.Animal;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AutoConfigTest {

    @ConditionalOnMissingBean
    @Bean
    public Animal getAnimal(){
        return new Animal();
    }
}
