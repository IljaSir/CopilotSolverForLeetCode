class Solution {
    public int findSubstringInWraproundString(String s) {
        
        int[] counts = new int[26];
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                length++;
            } else {
                length = 1;
            }
            counts[s.charAt(i) - 'a'] = Math.max(counts[s.charAt(i) - 'a'], length);
        }
        int sum = 0;
        for (int count : counts) {
            sum += count;
        }
        return sum;
    }
}