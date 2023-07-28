class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[j] - stones[i] > ans) break;
                ans = max(ans, stones[j] - stones[i]);
            }
        }
        return ans;
    }
    int frogJump(vector<int>& stones) {
        int n = stones.size();
        int ans = 0;
        while (true) {
            int maxJump = maxJump(stones);
            if (maxJump < ans) break;
            ans = maxJump;
        }
        return ans;
    }
};