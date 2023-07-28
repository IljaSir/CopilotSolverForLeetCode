class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        vector<int> result(heights.size(), 0);
        stack<int> stk;
        for (int i = 0; i < heights.size(); ++i) {
            while (!stk.empty() && heights[stk.top()] <= heights[i]) {
                result[stk.top()]++;
                stk.pop();
            }
            if (!stk.empty()) {
                result[stk.top()]++;
            }
            stk.push(i);
        }
        return result;
    }
};