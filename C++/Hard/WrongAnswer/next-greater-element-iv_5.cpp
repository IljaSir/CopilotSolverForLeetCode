class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        
        vector<int> res(nums.size(), -1);
        stack<int> st;
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.top()] <= nums[i]) {
                st.pop();
            }
            if (!st.empty()) {
                res[i] = nums[st.top()];
            }
            st.push(i);
        }
        return res;
    }
};