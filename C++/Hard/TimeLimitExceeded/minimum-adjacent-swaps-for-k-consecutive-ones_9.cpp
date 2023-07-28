class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> onePos;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                onePos.push_back(i);
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < onePos.size() - k + 1; i++) {
            int mid = onePos[i + k / 2];
            int cost = 0;
            for (int j = i; j < i + k; j++) {
                cost += abs(onePos[j] - mid) - abs(j - i - k / 2);
            }
            ans = min(ans, cost);
        }
        return ans;
    }
};