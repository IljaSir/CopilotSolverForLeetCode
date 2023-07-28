class Solution {
    public List<String> removeComments(String[] source) {
        
        StringBuffer sb = new StringBuffer();
        for (String s : source) {
            sb.append(s).append('\n');
        }
        String str = sb.toString();
        List<String> res = new ArrayList<>();
        boolean block = false;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && !block && str.charAt(i) == '/' && str.charAt(i + 1) == '*') {
                block = true;
                i++;
            } else if (i + 1 < str.length() && block && str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
                block = false;
                i++;
            } else if (i + 1 < str.length() && !block && str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                i++;
                while (i < str.length() && str.charAt(i) != '
    }
}