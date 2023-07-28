class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        
        stack<int> st;
        unordered_map<int, int> m;
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!st.empty() && st.top() <= nums[i])
                st.pop();
            if (st.empty())
                m[nums[i]] = -1;
            else
                m[nums[i]] = st.top();
            st.push(nums[i]);
        }
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++)
            ans.push_back(m[nums[i]]);
        return ans;
    }
};