class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        
        int n = nums.size() / 2;
        unordered_map<int, int> cnt;
        for (int i = 0; i < nums.size(); i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] == n) {
                return nums[i];
            }
        }
        return -1;
    }
};