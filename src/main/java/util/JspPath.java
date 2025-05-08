package util;

public final class JspPath {
    private static final String path = "/WEB-INF/pages/%s.jsp";

    public static String createPath(String filename) {
        return String.format(path,filename);
    }
}
