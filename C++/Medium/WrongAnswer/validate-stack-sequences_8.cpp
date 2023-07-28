class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        int i = 0, j = 0;
        stack<int> s;
        while (j < popped.size()) {
            if (i < pushed.size() && pushed[i] != popped[j]) {
                s.push(pushed[i]);
                i++;
            } else if (i < pushed.size() && pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!s.empty() && s.top() == popped[j]) {
                s.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
};