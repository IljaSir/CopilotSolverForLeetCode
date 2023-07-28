class Solution {
    public int minSwaps(String s) {
        
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                ans++;
                count = 1;
            }
        }
        return ans;
    }
}