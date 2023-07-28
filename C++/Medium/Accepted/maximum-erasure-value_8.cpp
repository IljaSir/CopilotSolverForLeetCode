class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int res = 0;
        int cur = 0;
        int i = 0;
        int j = 0;
        unordered_set<int> s;
        while (j < nums.size()) {
            if (s.find(nums[j]) == s.end()) {
                s.insert(nums[j]);
                cur += nums[j];
                res = max(res, cur);
                j++;
            } else {
                while (nums[i] != nums[j]) {
                    cur -= nums[i];
                    s.erase(nums[i]);
                    i++;
                }
                i++;
                j++;
            }
        }
        return res;
    }
};