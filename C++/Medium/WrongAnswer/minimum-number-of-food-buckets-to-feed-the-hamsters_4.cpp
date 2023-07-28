class Solution {
public:
    int minimumBuckets(string hamsters) {
        
        int n = hamsters.size();
        if (n < 2) return 0;
        int ans = 0;
        if (hamsters[0] == 'H') ans++;
        if (hamsters[n - 1] == 'H') ans++;
        for (int i = 1; i < n - 1; i++) {
            if (hamsters[i] == 'H') {
                if (hamsters[i - 1] == '.' && hamsters[i + 1] == '.') {
                    ans++;
                }
            }
        }
        return ans;
    }
};