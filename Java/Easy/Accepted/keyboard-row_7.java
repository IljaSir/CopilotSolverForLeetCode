class Solution {
    public String[] findWords(String[] words) {
        
        List<String> list = new ArrayList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (String word : words) {
            int row = 0;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].contains(word.substring(0, 1).toLowerCase())) {
                    row = i;
                    break;
                }
            }
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (!rows[row].contains(word.substring(i, i + 1).toLowerCase())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}