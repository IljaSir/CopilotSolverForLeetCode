class Solution {
public:
    string decodeString(string s) {
        
        stack<int> numStack;
        stack<string> strStack;
        string str;
        int num = 0;
        for (char c : s) {
            if (isdigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(str);
                num = 0;
                str = "";
            } else if (c == ']') {
                int times = numStack.top();
                numStack.pop();
                string tmp = strStack.top();
                strStack.pop();
                for (int i = 0; i < times; i++) {
                    tmp += str;
                }
                str = tmp;
            } else {
                str += c;
            }
        }
        return str;
    }
};