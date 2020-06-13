package top.easyblog.conf.web;

import java.util.HashMap;

/**
 * @author Huangxin
 * @ClassName: AjaxResult
 * @Description: AJAX执行结果
 * @date 2020/6/12
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult() {
    }


    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public AjaxResult error() {
        return error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg) {
        return new AjaxResult().error(500, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public AjaxResult error(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @param msg 内容
     * @return 成功消息
     */
    public AjaxResult success(String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public AjaxResult success() {
        return success("操作成功");
    }

    public AjaxResult successData(int code, Object value) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("data", value);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @param key   键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
