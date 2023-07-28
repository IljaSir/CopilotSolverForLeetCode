class Solution {
    public int divisorSubstrings(int num, int k) {
        
        int count = 0;
        String s = String.valueOf(num);
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (sub.startsWith("0") && sub.length() > 1) {
                continue;
            }
            if (num % Integer.parseInt(sub) == 0) {
                count++;
            }
        }
        return count;
    }
}