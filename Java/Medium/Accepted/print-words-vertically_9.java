class Solution {
    public List<String> printVertically(String s) {
        
        List<String> list = new ArrayList<>();
        String[] words = s.split(" ");
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(sb.toString());
        }
        return list;
    }
}