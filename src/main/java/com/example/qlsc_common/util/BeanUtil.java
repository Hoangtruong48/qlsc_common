package com.example.qlsc_common.util;



import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BeanUtil<T extends Serializable> {

    private BeanUtil() {
    }
    public static <T> T copyProperties(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        try {
            T t = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
        }
    }

    public static <T> List<T> copyProperties(List<?> source, Class<T> clazz) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> res = new ArrayList<>(source.size());
        for (Object o : source) {
            T t = null;
            try {
                t = clazz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(o, t);
            } catch (Exception e) {
                throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
            }
            res.add(t);
        }
        return res;
    }

    public static <T> List<T> copyPropertiesNew(List<?> source, Class<T> clazz) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }

        List<T> res = new ArrayList<>(source.size());

        for (Object o : source) {
            try {
                T t = clazz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(o, t);
                res.add(t);
            } catch (Exception e) {
                // Có thể log chi tiết hơn ở đây
                throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
            }
        }

        return res;
    }

    public static <T, K> List<T> distinctByKeyKeepFirst(
            List<T> list,
            Function<? super T, ? extends K> keyExtractor) {

        return distinctByKey(list, keyExtractor, (first, duplicate) -> first);
    }

    /**
     * Giữ phần tử xuất hiện cuối cùng, loại bỏ trùng theo key.
     */
    public static <T, K> List<T> distinctByKeyKeepLast(
            List<T> list,
            Function<? super T, ? extends K> keyExtractor) {

        return distinctByKey(list, keyExtractor, (first, duplicate) -> duplicate);
    }

    /**
     * Hàm tổng quát – bạn truyền hàm merge để quyết định giữ phần tử nào.
     *
     * @param list          danh sách gốc
     * @param keyExtractor  hàm trả về khóa duy nhất (vd. HocSinh::getSbd)
     * @param merge         chiến lược khi trùng khóa (BinaryOperator nhận 2 phần tử trùng)
     */
    public static <T, K> List<T> distinctByKey(
            List<T> list,
            Function<? super T, ? extends K> keyExtractor,
            BinaryOperator<T> merge) {

        return new ArrayList<>(
                list.stream()
                        .collect(Collectors.toMap(
                                keyExtractor,          // key
                                Function.identity(),   // value
                                merge,                 // cách gộp
                                LinkedHashMap::new     // giữ nguyên thứ tự
                        ))
                        .values()
        );
    }

}