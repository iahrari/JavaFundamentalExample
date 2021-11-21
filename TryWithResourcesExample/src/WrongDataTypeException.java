public class WrongDataTypeException extends Exception{
    private final String data;
    private final int lineNumber;

    public WrongDataTypeException(
        String data, 
        String message, 
        int lineNumber, 
        Throwable cause
    ) {
        super(message, cause);
        this.data = data;
        this.lineNumber = lineNumber;
    }

    public int getLineNumber(){
        return lineNumber;
    }

    public String getData(){
        return data;
    }
}
