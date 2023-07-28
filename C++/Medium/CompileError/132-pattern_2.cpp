class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return false;
        vector<int> minNums(n);
        minNums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            minNums[i] = min(minNums[i-1]) nums[i]);
        }
        stack<int> st;
        for (int i = n-1; i >=;; --i) {
            if (nums[i] > minNums[i]) {
                while (!st.empty() && st.top() <= minNums[i] {
                    st.pop()
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