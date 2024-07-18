package com.lv.self;

import java.util.Objects;

/**
 * @author 吕星琪
 * @version 1.10 2024/7/14 19:12
 * @description
 */
public class FamilyName {
    private String FirstLetter;
    private String fullChinese;

    public FamilyName() {
    }

    public FamilyName(String firstLetter, String fullChinese) {
        FirstLetter = firstLetter;
        this.fullChinese = fullChinese;
    }

    @Override
    public String toString() {
        return "FamilyName{" +
                "FirstLetter='" + FirstLetter + '\'' +
                ", fullChinese='" + fullChinese + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyName that = (FamilyName) o;
        return Objects.equals(FirstLetter, that.FirstLetter) && Objects.equals(fullChinese, that.fullChinese);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstLetter, fullChinese);
    }

    public String getFirstLetter() {
        return FirstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        FirstLetter = firstLetter;
    }

    public String getFullChinese() {
        return fullChinese;
    }

    public void setFullChinese(String fullChinese) {
        this.fullChinese = fullChinese;
    }
}
