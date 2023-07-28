class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        if (nums.size() < 3) return false;
        stack<int> s;
        int s2 = INT_MIN;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] < s2) return true;
            while (!s.empty() && nums[i] > s.top()) {
                s2 = s.top();
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
};