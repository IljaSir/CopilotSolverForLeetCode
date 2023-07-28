class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int ans = 0;
        if(x > y) {
            ans += solve(s, 'a', 'b', x, y);
            ans += solve(s, 'b', 'a', y, x);
        } else {
            ans += solve(s, 'b', 'a', y, x);
            ans += solve(s, 'a', 'b', x, y);
        }
        return ans;
    }
    
    int solve(string& s, char a, char b, int x, int y) {
        int ans = 0;
        stack<char> st;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == b) {
                if(!st.empty() && st.top() == a) {
                    ans += x;
                    st.pop();
                } else {
                    st.push(b);
                }
            } else {
                st.push(s[i]);
            }
        }
        string res;
        while(!st.empty()) {
            res += st.top();
            st.pop();
        }
        reverse(res.begin(), res.end());
        s = res;
        return ans;
    }
};