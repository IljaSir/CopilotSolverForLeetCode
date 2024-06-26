class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, -1);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && nums[s.top()] < nums[i]) {
                ans[s.top()] = nums[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
};