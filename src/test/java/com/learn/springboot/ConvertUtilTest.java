package com.learn.springboot;

import com.learn.springboot.utils.ConvertUtil;
import org.junit.Assert;
import org.junit.Test;

public class ConvertUtilTest {

    @Test
    public void testByte2Int(){
        for(int i = -128; i < 128; i++){
            Assert.assertEquals((byte) i, ConvertUtil.intToByte(i));
        }

        for(int i = 0; i < 256; i++){
            Assert.assertEquals(i, ConvertUtil.byteToUnsignedInt((byte)i));
        }
    }

    @Test
    public void testBytes2Short(){
        for(int i = -32768; i < 32767; i++){
            Assert.assertEquals((short) i, ConvertUtil.bytesToShort(ConvertUtil.shortToBytes((short) i)));
        }
    }

    @Test
    public void testBytes2Int(){
        for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){
            Assert.assertEquals(i, ConvertUtil.bytesToInt(ConvertUtil.intToBytes(i)));
        }
    }

    @Test
    public void testBytes2Long(){
        Assert.assertEquals(Long.MIN_VALUE, ConvertUtil.bytesToLong(ConvertUtil.longToBytes(Long.MIN_VALUE)));
        Assert.assertEquals((long) 0, ConvertUtil.bytesToLong(ConvertUtil.longToBytes((long) 0)));
        Assert.assertEquals(Long.MAX_VALUE, ConvertUtil.bytesToLong(ConvertUtil.longToBytes(Long.MAX_VALUE)));
    }
}
