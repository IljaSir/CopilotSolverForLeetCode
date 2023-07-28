class Solution {
public:
    string decodeString(string s) {
        
        stack<int> nums;
        stack<string> strs;
        int num = 0;
        string str;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + (s[i] - '0');
            } else if (s[i] == '[') {
                nums.push(num);
                strs.push(str);
                num = 0;
                str = "";
            } else if (s[i] == ']') {
                int n = nums.top();
                nums.pop();
                string tmp = strs.top();
                strs.pop();
                for (int j = 0; j < n; ++j) {
                    tmp += str;
                }
                str = tmp;
            } else {
                str += s[i];
            }
        }
        return str;
    }
};