class Solution {
public:
    string decodeString(string s) {
        
        string res;
        stack<string> stk;
        stack<int> cnt;
        int i = 0;
        while (i < s.size()) {
            if (isdigit(s[i])) {
                int n = 0;
                while (isdigit(s[i])) {
                    n = n * 10 + s[i] - '0';
                    i++;
                }
                cnt.push(n);
            } else if (s[i] == '[') {
                stk.push(res);
                res = "";
                i++;
            } else if (s[i] == ']') {
                string temp = stk.top();
                stk.pop();
                for (int j = 0; j < cnt.top(); j++) {
                    temp += res;
                }
                cnt.pop();
                res = temp;
                i++;
            } else {
                res += s[i++];
            }
        }
        return res;
    }
};