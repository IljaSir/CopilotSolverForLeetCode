class Solution {
    public String entityParser(String text) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                if (i + 5 < text.length() && text.substring(i, i + 6).equals("&frasl;")) {
                    sb.append("/");
                    i += 5;
                } else if (i + 4 < text.length() && text.substring(i, i + 5).equals("&gt;")) {
                    sb.append(">");
                    i += 4;
                } else if (i + 4 < text.length() && text.substring(i, i + 5).equals("&lt;")) {
                    sb.append("<");
                    i += 4;
                } else if (i + 4 < text.length() && text.substring(i, i + 5).equals("&amp;")) {
                    sb.append("&");
                    i += 4;
                } else if (i + 5 < text.length() && text.substring(i, i + 6).equals("&quot;")) {
                    sb.append("\"");
                    i += 5;
                } else if (i + 5 < text.length() && text.substring(i, i + 6).equals("&apos;")) {
                    sb.append("'");
                    i += 5;
                } else {
                    sb.append(text.charAt(i));
                }
            } else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }
}