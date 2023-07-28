class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.length();
        vector<int> prefixSum(n + 1);
        vector<int> last(10, -1);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s[i] - '0');
            last[s[i] - '0'] = i;
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            int maxEnd = 0;
            for (int j = 0; j < 10; j++) {
                if (last[j] > i) {
                    maxEnd = max(maxEnd, last[j]);
                    curr++;
                }
            }
            if (curr == 0) {
                break;
            }
            ans = min(ans, curr + 1);
            i = maxEnd;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};