package com.alibaba.fastjson;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

public class Issue3188Test extends TestCase {

    @Test
    public void test_for_issue() throws Exception {
        BigDecimal bigDecimal = new BigDecimal("23680390000000");
        JSONObject dec = new JSONObject();
        dec.put("amount", bigDecimal.doubleValue());
//        System.out.println(bigDecimal.doubleValue());
        assertEquals(dec.toJSONString(), JSONObject.parseObject(dec.toJSONString()).toJSONString());
    }
}
