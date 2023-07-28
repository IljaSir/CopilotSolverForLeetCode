class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        vector<int> left(nums.size(), 0);
        vector<int> right(nums.size(), 0);
        stack<int> s;
        for (int i = 0; i < nums.size(); i++) {
            while (!s.empty() && nums[s.top()] > nums[i]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = -1;
            } else {
                left[i] = s.top();
            }
            s.push(i);
        }
        
        while (!s.empty()) {
            s.pop();
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!s.empty() && nums[s.top()] >= nums[i]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = nums.size();
            } else {
                right[i] = s.top();
            }
            s.push(i);
        }
        
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += (long long)nums[i] * (i - left[i]) * (right[i] - i);
        }
        return ans;
    }
};