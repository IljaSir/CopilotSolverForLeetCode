class Solution {
    public String[] findWords(String[] words) {
        
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String row = null;
            for (String r : rows) {
                if (r.indexOf(Character.toLowerCase(word.charAt(0))) >= 0) {
                    row = r;
                    break;
                }
            }
            boolean match = true;
            for (int i = 1; i < word.length(); i++) {
                if (row.indexOf(Character.toLowerCase(word.charAt(i))) < 0) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res.add(word);
            }
        }
        String[] result = new String[res.size()];
        return res.toArray(result);
    }
}