class Solution {
    public String[] findWords(String[] words) {
        
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            int row = -1;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].indexOf(chars[0]) != -1) {
                    row = i;
                    break;
                }
            }
            boolean isSameRow = true;
            for (int i = 1; i < chars.length; i++) {
                if (rows[row].indexOf(chars[i]) == -1) {
                    isSameRow = false;
                    break;
                }
            }
            if (isSameRow) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}