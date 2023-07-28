class Solution {
    public String[] findWords(String[] words) {
        
        String[] row = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            int index = -1;
            for (int i = 0; i < row.length; i++) {
                if (row[i].indexOf(chars[0]) != -1) {
                    index = i;
                    break;
                }
            }
            boolean flag = true;
            for (int i = 1; i < chars.length; i++) {
                if (row[index].indexOf(chars[i]) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}