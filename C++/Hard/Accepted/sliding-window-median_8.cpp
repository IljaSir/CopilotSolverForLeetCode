class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        
        vector<double> res;
        int n = nums.size();
        multiset<int> s(begin(nums), begin(nums) + k);
        auto mid = next(begin(s), k / 2);
        for (int i = k; ; i++) {
            res.push_back((double(*mid) + *prev(mid, 1 - k % 2)) / 2);
            if (i == n) return res;
            s.insert(nums[i]);
            if (nums[i] < *mid) mid--;
            if (nums[i - k] <= *mid) mid++;
            s.erase(s.lower_bound(nums[i - k]));
        }
    }
};