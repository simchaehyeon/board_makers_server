package BMproject.BMproject1.global.error.exception;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorCode errorCode) {super(errorCode);}
}
