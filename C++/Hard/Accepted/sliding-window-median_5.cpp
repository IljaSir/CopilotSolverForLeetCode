class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        
        vector<double> ans;
        multiset<int> win(nums.begin(), nums.begin() + k);
        auto mid = next(win.begin(), k / 2);
        for (int i = k; ; i++) {
            ans.push_back((double(*mid) + *prev(mid, 1 - k % 2)) / 2);
            if (i == nums.size()) return ans;
            win.insert(nums[i]);
            if (nums[i] < *mid) mid--;
            if (nums[i - k] <= *mid) mid++;
            win.erase(win.lower_bound(nums[i - k]));
        }
    }
};