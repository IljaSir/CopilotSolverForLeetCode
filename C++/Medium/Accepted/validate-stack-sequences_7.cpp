class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        stack<int> s;
        int n = pushed.size();
        int i = 0, j = 0;
        while (i < n) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!s.empty() && s.top() == popped[j]) {
                s.pop();
                j++;
            } else {
                s.push(pushed[i]);
                i++;
            }
        }
        while (!s.empty() && j < n) {
            if (s.top() == popped[j]) {
                s.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
};