class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        
        int n = nums.size();
        if (n < 2) return false;
        multiset<long long> s;
        for (int i = 0; i < n; i++) {
            if (i > indexDiff) s.erase(s.find(nums[i - indexDiff - 1]));
            auto it = s.lower_bound((long long)nums[i] - valueDiff);
            if (it != s.end() && *it - nums[i] <= valueDiff) return true;
            s.insert(nums[i]);
        }
        return false;
    }
};