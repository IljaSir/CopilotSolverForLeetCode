class Solution {
    public int divisorSubstrings(int num, int k) {
        
        int count = 0;
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() - k + 1; i++) {
            if (Integer.parseInt(str.substring(i, i + k)) % num == 0) {
                count++;
            }
        }
        return count;
    }
}