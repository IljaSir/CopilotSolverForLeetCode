class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int n = s.size();
        vector<int> count(26, 0);
        vector<bool> visited(26, false);
        for (char c : s) {
            count[c - 'a']++;
        }
        stack<char> st;
        for (char c : s) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!st.empty() && st.top() > c && count[st.top() - 'a'] > 0) {
                visited[st.top() - 'a'] = false;
                st.pop();
            }
            st.push(c);
            visited[c - 'a'] = true;
        }
        string result;
        while (!st.empty()) {
            result += st.top();
            st.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};