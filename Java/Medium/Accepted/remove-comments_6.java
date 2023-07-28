class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        if (source == null || source.length == 0) {
            return result;
        }
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!inBlock) {
                    sb.append(line.charAt(i));
                }
            }
            if (!inBlock && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}