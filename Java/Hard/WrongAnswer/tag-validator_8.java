class Solution {
    public boolean isValid(String code) {
        
        return parse(code) == code.length();
    }
    private int parse(String code) {
        int i = 0;
        int n = code.length();
        while (i < n) {
            if (i > 0 && code.charAt(i) != '<') return i;
            if (code.startsWith("</", i)) {
                int j = code.indexOf(">", i + 2);
                if (j < 0) return i;
                String tag = code.substring(i + 2, j);
                if (tag.length() < 1 || tag.length() > 9) return i;
                for (char c : tag.toCharArray()) {
                    if (!Character.isUpperCase(c)) return i;
                }
                return j + 1;
            } else if (code.startsWith("<![CDATA[", i)) {
                int j = code.indexOf("]]>", i + 9);
                if (j < 0) return i;
                return j + 3;
            } else {
                int j = code.indexOf("<", i + 1);
                if (j < 0) return n;
                int k = parse(code.substring(i + 1, j));
                if (k == j - i - 1) return n;
                i = j + k;
            }
        }
        return i;
    }
}