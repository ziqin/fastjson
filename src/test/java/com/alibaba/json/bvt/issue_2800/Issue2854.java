package com.alibaba.json.bvt.issue_2800;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

// https://github.com/alibaba/fastjson/issues/2854
public class Issue2854 {
    @Test
    public void testParseEnumName() {
        assertEquals(LevelFeeRateEnum.ONE, JSON.parseObject("\"ONE\"", LevelFeeRateEnum.class));
    }

    @Test
    public void parseUnambiguousEnum() {
        LevelFeeRateEnum enumeration = JSON.parseObject("{\"feeRate\": 0, \"level\": 1}", LevelFeeRateEnum.class);
        assertEquals(LevelFeeRateEnum.ONE, enumeration);
    }

    @Test
    public void parseInternalHiddenEnum() {
        assertEquals(InternalHiddenEnum.ONE, JSON.parseObject("{\"value\": 1}", InternalHiddenEnum.class));
        assertEquals(InternalHiddenEnum.TWO, JSON.parseObject("{\"value\": 2}", InternalHiddenEnum.class));
    }

    public enum LevelFeeRateEnum {
        ONE(1, BigDecimal.ZERO),
        TWO(2, new BigDecimal("0.75")),
        THREE(3, new BigDecimal("0.75")),
        FOUR(4, new BigDecimal("0.75")),
        FIVE(5, new BigDecimal("0.75"));

        private final int level;
        private final BigDecimal feeRate;

        LevelFeeRateEnum(int level, BigDecimal feeRate) {
            this.level = level;
            this.feeRate = feeRate;
        }

        public int getLevel() {
            return level;
        }

        public BigDecimal getFeeRate() {
            return feeRate;
        }
    }

    public enum InternalHiddenEnum {
        ONE(0), TWO(1);

        private final int value;

        InternalHiddenEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value + 1;
        }
    }

}
