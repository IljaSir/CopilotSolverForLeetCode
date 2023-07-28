class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = 0, sum = 0, res = 0;
        unordered_set<int> s;
        while (r < n) {
            while (s.find(nums[r]) != s.end()) {
                s.erase(nums[l]);
                sum -= nums[l];
                l++;
            }
            s.insert(nums[r]);
            sum += nums[r];
            res = max(res, sum);
            r++;
        }
        return res;
    }
};