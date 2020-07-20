package io.github.tommyadmin.common.handler;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Tommy
 * @since 2020-07-19
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * -------- 通用异常处理方法 --------
     */
    @ExceptionHandler(Exception.class)
    public R<Object> error(Exception e) {
        e.printStackTrace();
        return R.failed("系统内部错误！");
    }

    /**
     * -------- 指定异常处理方法 --------
     */
    @ExceptionHandler(NullPointerException.class)
    public R<Object> error(NullPointerException e) {
        e.printStackTrace();
        return R.failed("空指针异常！");
    }

    /**
     * -------- 自定义定异常处理方法 --------
     */
    @ExceptionHandler(ApiException.class)
    public R<Object> error(ApiException e) {
        e.printStackTrace();
        return R.failed(e.getMessage());
    }
}
