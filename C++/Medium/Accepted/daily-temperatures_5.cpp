class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        vector<int> res(temperatures.size(), 0);
        stack<int> stk;
        for (int i = 0; i < temperatures.size(); i++) {
            while (!stk.empty() && temperatures[i] > temperatures[stk.top()]) {
                int t = stk.top();
                stk.pop();
                res[t] = i - t;
            }
            stk.push(i);
        }
        return res;
    }
};