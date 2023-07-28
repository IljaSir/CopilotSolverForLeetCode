class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = start ^ nums[i];
            int y = goal ^ nums[i];
            int cnt = 0;
            while (x) {
                if (x % 2 != y % 2) {
                    cnt++;
                }
                x /= 2;
                y /= 2;
            }
            ans += cnt;
        }
        return ans;
    }
};