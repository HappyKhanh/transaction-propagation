package me.demo.transaction.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class BookUtils {

        public String genUUid(){
            UUID uuid = UUID.randomUUID();
            String s = uuid.toString();
            return s;
        }

        @Transactional(propagation = Propagation.NEVER)
        public void neverTrans(){
            System.out.println("Hello !!");
        }
}
