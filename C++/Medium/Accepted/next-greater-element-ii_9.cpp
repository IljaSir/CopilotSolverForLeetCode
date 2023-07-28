class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        vector<int> result(nums.size(), -1);
        stack<int> s;
        for (int i = 0; i < nums.size() * 2; ++i) {
            while (!s.empty() && nums[s.top()] < nums[i % nums.size()]) {
                result[s.top()] = nums[i % nums.size()];
                s.pop();
            }
            s.push(i % nums.size());
        }
        return result;
    }
};