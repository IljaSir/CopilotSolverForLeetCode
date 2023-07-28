class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int n = nums.size();
        vector<int> left(n);
        vector<int> right(n);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && nums[s.top()] < nums[i]) {
                s.pop();
            }
            left[i] = s.empty() ? -1 : s.top();
            s.push(i);
        }
        s = stack<int>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && nums[s.top()] < nums[i]) {
                s.pop();
            }
            right[i] = s.empty() ? n : s.top();
            s.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            if (minK <= nums[i] && nums[i] <= maxK) {
                ans += (i - left[i]) * (right[i] - i);
            }
        }
        return ans;
    }
};