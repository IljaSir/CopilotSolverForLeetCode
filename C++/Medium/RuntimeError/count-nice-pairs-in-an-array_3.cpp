class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        map<int, int> m;
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i], y = 0;
            while (x) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            int diff = y - nums[i];
            ans += m[diff];
            m[diff]++;
        }
        return ans % (1000000000 + 7);
    }
};