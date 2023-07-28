class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inComment = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (!inComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inComment = true;
                    i++;
                } else if (inComment && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inComment = false;
                    i++;
                } else if (!inComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!inComment) {
                    sb.append(line.charAt(i));
                }
            }
            if (!inComment && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}