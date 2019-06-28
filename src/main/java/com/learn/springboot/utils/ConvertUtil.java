package com.learn.springboot.utils;


/**
 * 简易类型转换
 */
public class ConvertUtil {

    /**
     * int value to byte
     * @param value int
     * @return byte value
     * range [-128, 127]
     */
    public static byte intToByte(int value){
        return (byte) value;
    }


    /**
     * byte value to int
     * @param value byte
     * @return int value
     * range [0, 256]
     */
    public static int byteToUnsignedInt(byte value){
        return value & 0xff;
    }


    /**
     * short to byte array
     * @param value short
     * @return byte array
     * range [-32768, 32767]
     */
    public static byte[] shortToBytes(short value){
        byte[] b = new byte[2];
        b[1] = (byte) (value & 0xff);
        b[0] = (byte) ((value >> 8) & 0xff);
        return b;
    }


    /**
     * byte array to short
     * @param bytes byte array
     * @return short value
     * range [-32768, 32767]
     */
    public static short bytesToShort(byte[] bytes){
        return (short) (bytes[1] & 0xff | (bytes[0] & 0xff) << 8);
    }


    /**
     * int value to byte array
     * @param value int
     * @return byte array
     * range [-2147483648, 2147483647]
     */
    public static byte[] intToBytes(int value){
        byte[] b = new byte[4];
        b[3] = (byte) (0xff & value);
        b[2] = (byte) (0xff & (value >> 8));
        b[1] = (byte) (0xff & (value >> 16));
        b[0] = (byte) (0xff & (value >> 24));
        return b;
    }


    /**
     * byte array to int value
     * @param bytes byte array
     * @return int value
     * range [-2147483648, 2147483647]
     */
    public static int bytesToInt(byte[] bytes){
        return   bytes[3] & 0xff |
                (bytes[2] & 0xff) << 8  |
                (bytes[1] & 0xff) << 16 |
                (bytes[0] & 0xff) << 24;
    }


    /**
     * long value to byte array
     * @param value long
     * @return byte array
     */
    public static byte[] longToBytes(long value){
        byte[] bytes = new byte[8];
        for(int i = 7; i >= 0; i--) {
            bytes[i] = (byte) (value & 0xff);
            value = value >> 8;
        }
        return bytes;
    }


    /**
     * byte array to long value
     * @param bytes byte array
     * @return long value
     */
    public static long bytesToLong(byte[] bytes){
        long value = 0;
        for(byte b : bytes){
            value = value << 8;
            value = value | (b & 0xff);
        }
        return value;
    }
}
