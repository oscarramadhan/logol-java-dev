package com.logol.java.developer.Utility;

import java.util.UUID;

public class GeneratorUtil {
    public static String GenerateUuid(){
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

		return uuidString;
    }
}