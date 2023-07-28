class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        stack<int> st;
        int n = pushed.size();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (st.empty() || st.top() != popped[j]) {
                st.push(pushed[i]);
                i++;
            }
            else {
                st.pop();
                j++;
            }
        }
        while (j < n) {
            if (st.top() != popped[j]) return false;
            st.pop();
            j++;
        }
        return true;
    }
};