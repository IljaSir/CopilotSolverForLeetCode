class Solution {
    public int maxProduct(String[] words) {
        
        int res = 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                masks[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}