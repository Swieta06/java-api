package OneToOne.example.onetoone_task.dto;


public class ResponseDto<T>{

    private String message;
    private  String status;
    //private List<MobilDto>mobilDto;
    private  T data;
}
