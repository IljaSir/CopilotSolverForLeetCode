class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        vector<int> res(nums.size(), -1);
        stack<int> s;
        for (int i = 0; i < nums.size() * 2; i++) {
            while (!s.empty() && nums[i % nums.size()] > nums[s.top()]) {
                res[s.top()] = nums[i % nums.size()];
                s.pop();
            }
            s.push(i % nums.size());
        }
        return res;
    }
};