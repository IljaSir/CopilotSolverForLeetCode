class Solution {
public:
    int minimumBuckets(string hamsters) {
        
        int n = hamsters.size();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters[i] == 'H') {
                if (cnt == 0) {
                    ans++;
                }
                cnt = 2;
            } else {
                cnt = max(0, cnt - 1);
            }
        }
        if (cnt > 0) {
            return -1;
        }
        return ans;
    }
};