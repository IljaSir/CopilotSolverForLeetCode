class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> min(n);
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = min[i-1] < nums[i] ? min[i-1] : nums[i];
        }
        stack<int> s;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!s.empty() && s.top() <= min[i]) {
                    s.pop();
                }
                if (!s.empty() && s.top() < nums[i]) {
                    return true;
                }
                s.push(nums[i]);
            }
        }
        return false;
    }
};