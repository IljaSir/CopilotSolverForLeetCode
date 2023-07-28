class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        boolean block = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (block && i < s.length() - 1 && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                    block = false;
                    i++;
                } else if (block) {
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                    block = true;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                    break;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            if (!block && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}