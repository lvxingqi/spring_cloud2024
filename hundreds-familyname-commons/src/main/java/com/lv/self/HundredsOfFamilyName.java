package com.lv.self;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HundredsOfFamilyName {
    private List<FamilyName> familyNames;

    private void init() throws IOException {
        //将百家姓载入内存
        String[] CHARACTERS;
        try (FileInputStream inputStream = new FileInputStream("D:\\快捷桌面文件\\编程\\java_test\\cloud2024\\hundreds-familyname-commons\\src\\main\\resources\\HundredsOfFamilyName.txt");
             FileChannel fileChannel = inputStream.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(2048);
            StringBuilder content = new StringBuilder();
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                content.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }
            CHARACTERS = content.toString().split("\\s+");
        }
        //循环读取，构建姓氏对象并加入列表
        familyNames=new ArrayList<>();
        for (String character : CHARACTERS) {
            String[] letters = PinyinHelper.toHanyuPinyinStringArray(character.charAt(0));
            if (letters != null) {
                FamilyName familyName = new FamilyName();
                familyName.setFullChinese(character);
                familyName.setFirstLetter(String.valueOf(letters[0].toCharArray()[0]));
                familyNames.add(familyName);
            }
        }
    }
    public HundredsOfFamilyName() throws IOException {
        init();
    }
    public List<String> getCharactersByInitial(String initial) {
        List<String> matchingCharacters = new ArrayList<>();
        for (FamilyName familyName: familyNames){
            if (familyName.getFirstLetter().equals(initial)){
                matchingCharacters.add(familyName.getFullChinese());
            }
        }
        return matchingCharacters;
    }
}
