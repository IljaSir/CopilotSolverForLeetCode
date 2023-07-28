class Solution {
    public String[] findWords(String[] words) {
        
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int row = 0;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].indexOf(Character.toLowerCase(word.charAt(0))) != -1) {
                    row = i;
                    break;
                }
            }
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (rows[row].indexOf(Character.toLowerCase(word.charAt(i))) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}