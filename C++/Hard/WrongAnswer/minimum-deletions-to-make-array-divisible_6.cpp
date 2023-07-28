class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size(), m = numsDivide.size();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int g = numsDivide[i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (g % nums[j] == 0) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                return -1;
            }
            ans += n - cnt;
        }
        return ans;
    }
};