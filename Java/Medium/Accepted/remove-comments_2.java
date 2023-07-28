class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder newString = new StringBuilder();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) {
                newString = new StringBuilder();
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
                    newString.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newString.length() > 0) {
                result.add(newString.toString());
            }
        }
        return result;
    }
}