class Solution {
    public int divisorSubstrings(int num, int k) {
        
        String numStr = String.valueOf(num);
        int count = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            String sub = numStr.substring(i, i + k);
            if (sub.charAt(0) != '0' && num % Integer.valueOf(sub) == 0) {
                count++;
            }
        }
        return count;
    }
}