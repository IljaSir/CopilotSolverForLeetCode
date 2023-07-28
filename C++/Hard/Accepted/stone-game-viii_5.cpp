class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> ps(n);
        ps[0] = stones[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + stones[i];
        }
        int ans = ps[n - 1];
        for (int i = n - 2; i > 0; i--) {
            ans = max(ans, ps[i] - ans);
        }
        return ans;
    }
};