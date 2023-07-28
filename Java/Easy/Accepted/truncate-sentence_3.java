class Solution {
    public String truncateSentence(String s, int k) {
        
        int count = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    break;
                }
            }
            result += s.charAt(i);
        }
        return result;
    }
}