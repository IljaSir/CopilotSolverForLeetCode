class Solution {
public:
    bool validPartition(vector<int>& nums) {
        
        int n = nums.size();
        int cnt[1000001] = {};
        int cnt2[1000001] = {};
        int cnt3[1000001] = {};
        for (auto &x: nums) {
            cnt[x]++;
            if (cnt[x] == 2) cnt2[x]++;
            if (cnt[x] == 3) cnt3[x]++;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) {
                if (cnt2[nums[i-1]] == 1) cnt2[nums[i-1]]--;
                else if (cnt3[nums[i-1]] == 1) cnt3[nums[i-1]]--;
            }
        }
        for (int i = 0; i < 1000001; i++) {
            if (cnt2[i] == 1 || cnt3[i] == 1) return true;
        }
        return false;
    }
};