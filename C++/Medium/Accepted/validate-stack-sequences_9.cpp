class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        int n = pushed.size();
        int m = popped.size();
        if (n != m) return false;
        stack<int> stk;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else {
                if (stk.empty()) {
                    stk.push(pushed[i++]);
                } else {
                    if (stk.top() == popped[j]) {
                        stk.pop();
                        j++;
                    } else {
                        stk.push(pushed[i++]);
                    }
                }
            }
        }
        while (j < m) {
            if (stk.top() != popped[j]) return false;
            stk.pop();
            j++;
        }
        return true;
    }
};