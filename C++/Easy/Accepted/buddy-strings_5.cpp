class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if(s.size() != goal.size()) return false;
        if(s == goal) {
            unordered_set<char> st;
            for(char c : s) {
                if(st.count(c)) return true;
                st.insert(c);
            }
            return false;
        }
        int first = -1;
        int second = -1;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] != goal[i]) {
                if(first == -1) {
                    first = i;
                } else if(second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return second != -1 && s[first] == goal[second] && s[second] == goal[first];
    }
};