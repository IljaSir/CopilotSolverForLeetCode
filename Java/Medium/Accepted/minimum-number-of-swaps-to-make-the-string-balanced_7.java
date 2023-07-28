class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    ans++;
                    cnt = 1;
                }
            }
        }
        return ans;
    }
}