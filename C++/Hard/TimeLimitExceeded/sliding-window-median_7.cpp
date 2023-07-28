class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        
        vector<double> ans;
        multiset<int> s;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                s.erase(s.find(nums[i - k]));
            }
            s.insert(nums[i]);
            if (i >= k - 1) {
                auto it = next(s.begin(), k / 2);
                ans.push_back((double(*it) + *prev(it, 1 - k % 2)) / 2);
            }
        }
        return ans;
    }
};