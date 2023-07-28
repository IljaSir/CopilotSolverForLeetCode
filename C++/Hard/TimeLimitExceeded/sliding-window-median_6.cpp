class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        
        multiset<int> s;
        vector<double> ans;
        for (int i = 0; i < nums.size(); i++) {
            if (i >= k) {
                s.erase(s.find(nums[i - k]));
            }
            s.insert(nums[i]);
            if (i >= k - 1) {
                auto it = s.begin();
                advance(it, k / 2);
                if (k % 2) {
                    ans.push_back(*it);
                } else {
                    ans.push_back(((double)*it + *prev(it)) / 2);
                }
            }
        }
        return ans;
    }
};