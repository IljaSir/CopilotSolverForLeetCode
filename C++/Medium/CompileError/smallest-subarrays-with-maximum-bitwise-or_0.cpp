class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) st.pop();
            ans[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<int> ans(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] <= nums[i]) st.pop();
            ans[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<int> ans(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) st.pop();
            ans[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<int> ans(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) st.pop();
            ans[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        return ans;
    }
    vector<int> minSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<int> ans(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) st.pop();
            ans[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
    }
};