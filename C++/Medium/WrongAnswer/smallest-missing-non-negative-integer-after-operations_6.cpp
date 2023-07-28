class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            int nxt = nums[i];
            if (nxt - cur > value) {
                return cur + value;
            }
            value -= nxt - cur;
            cur = nxt;
        }
        return cur + value;
    }
};