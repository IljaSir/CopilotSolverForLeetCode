class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) {
                sb = new StringBuilder();
            }
            while (i < chars.length) {
                if (!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    sb.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}