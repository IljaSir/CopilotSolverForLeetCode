class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        vector<int> ans;
        vector<int> stack;
        for (int i = 0; i < obstacles.size(); i++) {
            int cur = obstacles[i];
            if (stack.empty() || stack.back() <= cur) {
                stack.push_back(cur);
                ans.push_back(stack.size());
            } else {
                int pos = lower_bound(stack.begin(), stack.end(), cur) - stack.begin();
                stack[pos] = cur;
                ans.push_back(pos + 1);
            }
        }
        return ans;
    }
};