class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (cnt == 0) {
                    ans++;
                }
                cnt = 2;
            } else {
                cnt--;
            }
        }
        return cnt > 0 ? -1 : ans;
    }
}