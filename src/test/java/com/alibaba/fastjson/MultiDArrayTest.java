package com.alibaba.fastjson;

import org.glassfish.jersey.server.JSONP;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiDArrayTest {
    private static String jsonString =
            "{\n" +
                    "    \"data\": [\n" +
                    "        [\n" +
                    "            {\n" +
                    "                \"value\": 1958,\n" +
                    "                \"hb\": -0.03\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"value\": 0.28,\n" +
                    "                \"hb\": -0.04\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        [\n" +
                    "            {\n" +
                    "                \"value\": 1,\n" +
                    "                \"hb\": 2\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"value\": null,\n" +
                    "                \"hb\": 4\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    ]\n" +
                    "}";
    private Object value;
    private static String string =
            "BODY\n" +
                    "{\n" +
                    "   \"code\" : 200,\n" +
                    "   \"msg\" : \"成功!\",\n" +
                    "   \"data\" : {\n" +
                    "      \"yesterday\" : {\n" +
                    "         \"date\" : \"13日星期一\",\n" +
                    "         \"high\" : \"高温 23℃\",\n" +
                    "         \"fx\" : \"东北风\",\n" +
                    "         \"low\" : \"低温 18℃\",\n" +
                    "         \"fl\" : \"<![CDATA[3-4级]]>\",\n" +
                    "         \"type\" : \"小雨\"\n" +
                    "      },\n" +
                    "      \"city\" : \"杭州\",\n" +
                    "      \"aqi\" : null,\n" +
                    "      \"forecast\" : [\n" +
                    "         {\n" +
                    "            \"date\" : \"14日星期二\",\n" +
                    "            \"high\" : \"24\",\n" +
                    "            \"fengli\" : \"<![CDATA[3-4级]]>\",\n" +
                    "            \"low\" : \"18\",\n" +
                    "            \"fengxiang\" : \"东北风\",\n" +
                    "            \"type\" : \"多云\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"date\" : \"15日星期三\",\n" +
                    "            \"high\" : \"22\",\n" +
                    "            \"fengli\" : \"<![CDATA[3-4级]]>\",\n" +
                    "            \"low\" : \"19\",\n" +
                    "            \"fengxiang\" : \"东北风\",\n" +
                    "            \"type\" : \"中到大雨\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"date\" : \"16日星期四\",\n" +
                    "            \"high\" : \"25\",\n" +
                    "            \"fengli\" : \"<![CDATA[<3级]]>\",\n" +
                    "            \"low\" : \"19\",\n" +
                    "            \"fengxiang\" : \"东北风\",\n" +
                    "            \"type\" : \"多云\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"date\" : \"17日星期五\",\n" +
                    "            \"high\" : \"30\",\n" +
                    "            \"fengli\" : \"<![CDATA[<3级]]>\",\n" +
                    "            \"low\" : \"22\",\n" +
                    "            \"fengxiang\" : \"无持续风向\",\n" +
                    "            \"type\" : \"小雨\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"date\" : \"18日星期六\",\n" +
                    "            \"high\" : \"33\",\n" +
                    "            \"fengli\" : \"<![CDATA[<3级]]>\",\n" +
                    "            \"low\" : \"19,\n" +
                    "            \"fengxiang\" : \"无持续风向\",\n" +
                    "            \"type\" : \"多云\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"ganmao\" : \"各项气象条件适宜，无明显降温过程，发生感冒机率较低。\",\n" +
                    "      \"wendu\" : \"21\"\n" +
                    "   }\n" +
                    "}\n";

    @Test
    public void testDollarSelect() {
        value = JSONPath.eval(jsonString, "$.data[*][0].value");
        assertEquals("[1958,0.28]", value.toString());
        value = JSONPath.eval(jsonString, "$.data[*][1].value");
        assertEquals("[1]", value.toString());
    }

    @Test
    public void testSelect() {
        value = JSONPath.eval(jsonString, "$.data[*][?(value)]");
        assertEquals("[{\"value\":0.28,\"hb\":-0.04}]", value.toString());
    }
}
