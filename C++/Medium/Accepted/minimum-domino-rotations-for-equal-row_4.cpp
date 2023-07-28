class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int cnt[7] = {0};
        for (int i = 0; i < n; ++i) {
            if (tops[i] == bottoms[i]) {
                cnt[tops[i]]++;
            } else {
                cnt[tops[i]]++;
                cnt[bottoms[i]]++;
            }
        }
        int ans = INT_MAX;
        for (int i = 1; i <= 6; ++i) {
            if (cnt[i] == n) {
                int a = 0, b = 0;
                for (int j = 0; j < n; ++j) {
                    if (tops[j] != i) a++;
                    if (bottoms[j] != i) b++;
                }
                ans = min(ans, min(a, b));
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};