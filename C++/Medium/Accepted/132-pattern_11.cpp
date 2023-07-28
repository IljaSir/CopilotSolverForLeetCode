class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> minLeft(n, 0);
        minLeft[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            minLeft[i] = min(minLeft[i-1], nums[i]);
        }
        stack<int> st;
        for (int i = n-1; i >= 0; --i) {
            if (nums[i] > minLeft[i]) {
                while (!st.empty() && st.top() <= minLeft[i]) {
                    st.pop();
                }
                if (!st.empty() && st.top() < nums[i]) {
                    return true;
                }
                st.push(nums[i]);
            }
        }
        return false;
    }
};