package builder;

public class Builder {
    public String stringBuilderTest()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("this is the example ");
        stringBuilder.append("of the builder pattern.");
        stringBuilder.append("It has method to append" );
        stringBuilder.append("almost anything we want to a string");
        stringBuilder.append( 42);
        return stringBuilder.toString();
    }
}
