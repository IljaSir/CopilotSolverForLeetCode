class Solution {
    public List<String> printVertically(String s) {
        
        String[] words = s.split(" ");
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            maxLen = Math.max(maxLen, words[i].length());
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                } else {
                    sb.append(' ');
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}