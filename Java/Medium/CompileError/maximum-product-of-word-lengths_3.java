class Solution {
    public int maxProduct(String[] words) {
        
        int n = words.length;
        int[] mask = new int[n];
        for (int is = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }s
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max =s Math.max(smax, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}