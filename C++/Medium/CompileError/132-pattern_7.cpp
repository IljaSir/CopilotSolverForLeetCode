class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        if (nums.size() < in(minNums[i-1], nums[i]);
        }
        stack<int> st;
        for (int i = n-1; i >= 0; --i) {
            if (nums[i] > minNums[i]) {
                while (!st.empty() && st.top() <= minNums[i]) {
                   = s.top();
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
};