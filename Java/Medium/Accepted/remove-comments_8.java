class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isComment = false;
        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (!isComment && i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    isComment = true;
                    i++;
                } else if (isComment && i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    isComment = false;
                    i++;
                } else if (!isComment && i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!isComment) {
                    sb.append(line.charAt(i));
                }
                i++;
            }
            if (!isComment && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}