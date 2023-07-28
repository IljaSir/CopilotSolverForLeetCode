class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> ones;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                ones.push_back(i);
            }
        }
        long long ans = INT_MAX;
        for (int i = 0; i < ones.size() - k + 1; i++) {
            int mid = ones[i + k / 2 - 1];
            long long cost = 0;
            for (int j = i; j < i + k; j++) {
                cost += abs(mid - ones[j]);
            }
            ans = min(ans, cost);
        }
        return ans;
    }
};