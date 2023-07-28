class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        
        multiset<long> s;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (i > indexDiff) {
                s.erase(s.find(nums[i - indexDiff - 1]));
            }
            auto it = s.lower_bound((long)nums[i] - valueDiff);
            if (it != s.end() && *it <= (long)nums[i] + valueDiff) {
                return true;
            }
            s.insert(nums[i]);
        }
        return false;
    }
};