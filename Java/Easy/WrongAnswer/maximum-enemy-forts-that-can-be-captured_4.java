class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++) {
            left[i] = i;
            right[i] = i;
        }
        for(int i = 1; i < n; i++) {
            if(forts[i] == 0) {
                left[i] = left[i - 1];
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            if(forts[i] == 0) {
                right[i] = right[i + 1];
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(forts[i] == 0) {
                continue;
            }
            int l = left[i];
            int r = right[i];
            int cur = 0;
            while(l < i) {
                if(forts[l] == 0) {
                    cur++;
                }
                l++;
            }
            while(r > i) {
                if(forts[r] == 0) {
                    cur++;
                }
                r--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}