package com.yurifont.LiterFont.service;

public interface IConvertData {
    <T> T convertData(String json, Class<T> _class);
}
