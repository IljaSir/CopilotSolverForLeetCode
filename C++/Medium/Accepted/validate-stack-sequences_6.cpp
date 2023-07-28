class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        stack<int> st;
        int i = 0, j = 0;
        while (i < pushed.size() && j < popped.size()) {
            if (st.size() > 0 && st.top() == popped[j]) {
                st.pop();
                j++;
            } else {
                st.push(pushed[i]);
                i++;
            }
        }
        while (j < popped.size() && st.top() == popped[j]) {
            st.pop();
            j++;
        }
        return st.empty();
    }
};