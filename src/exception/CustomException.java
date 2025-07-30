/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author milan
 */
public class CustomException extends Exception{
    private String errorCode;
    
    public CustomException(String errorCode){
        super(errorCode);
        this.errorCode=errorCode;
    }
    
    public String getErrorCode(){
        return errorCode;
    }
}
