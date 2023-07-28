class Solution {
    public int divisorSubstrings(int num, int k) {
        
        String s = String.valueOf(num);
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - k + 1; i++) {
            String sub = s.substring(i, i + k);
            int subNum = Integer.parseInt(sub);
            if (subNum % num == 0) {
                count++;
            }
        }
        return count;
    }
}