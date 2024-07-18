package com.lv.self;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.IOException;
import java.util.*;

public class ChineseCharacterFinder {


    public static void main(String[] args) throws IOException {
        String[] strings = PinyinHelper.toHanyuPinyinStringArray("苍".charAt(0));
        System.out.println(Arrays.toString(strings));
        Scanner scanner=new Scanner(System.in);
        String initial=scanner.next();
        HundredsOfFamilyName hundredsOfFamilyName=new HundredsOfFamilyName();
        List<String> matchingCharacters = hundredsOfFamilyName.getCharactersByInitial(initial);
        System.out.println("汉字首字母为 " + initial + " 的有: " + matchingCharacters);
    }


}
