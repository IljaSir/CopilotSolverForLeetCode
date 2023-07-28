class Solution {
    public int maxProduct(String[] words) {
        
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            fo (itj = i + 1; j < n; j++) {
                if ((sk[i] & mask[j]) == 0) {
                    ans = Math.ma(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans
    }
}