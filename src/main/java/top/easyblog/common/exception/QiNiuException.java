package top.easyblog.common.exception;

import lombok.Data;
import top.easyblog.common.exception.enums.QiNiuErrorEnum;

/**
 * QiNiuException
 *
 * @author Huangxin
 * @date 2018/10/07 13:54
 * @description 自定义异常
 */
@Data
public class QiNiuException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String msg;
    private int code = 500;

    public QiNiuException(){
        super(QiNiuErrorEnum.UNKNOWN.getMsg());
        this.msg= QiNiuErrorEnum.UNKNOWN.getMsg();
    }


    public QiNiuException(QiNiuErrorEnum eEnum, Throwable e){
        super(eEnum.getMsg(),e);
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }

    public QiNiuException(QiNiuErrorEnum eEnum){
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }

    public QiNiuException(String exception){
       this.msg=exception;
    }

	public QiNiuException(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
    
}
