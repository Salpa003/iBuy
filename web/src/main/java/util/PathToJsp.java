package util;

public final class PathToJsp {
    private static String path ="WEB-INF/pages/%s.jsp";

    public static String create(String filename) {
        return String.format(path,filename);
    }
}
