class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean blockComment = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (!blockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    blockComment = true;
                    i++;
                } else if (blockComment && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    blockComment = false;
                    i++;
                } else if (!blockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!blockComment) {
                    sb.append(line.charAt(i));
                }
            }
            if (!blockComment && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}