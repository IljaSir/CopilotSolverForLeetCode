class Solution {
public:
    int calculate(string s) {
        
        int result = 0;
        int num = 0;
        char op = '+';
        stack<int> nums;
        for (int i = 0; i < s.length(); ++i) {
            if (isdigit(s[i])) {
                num = num * 10 + s[i] - '0';
            }
            if (!isdigit(s[i]) && s[i] != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        nums.push(num);
                        break;
                    case '-':
                        nums.push(-num);
                        break;
                    case '*':
                        num *= nums.top();
                        nums.pop();
                        nums.push(num);
                        break;
                    case '/':
                        num = nums.top() / num;
                        nums.pop();
                        nums.push(num);
                        break;
                }
                num = 0;
                op = s[i];
            }
        }
        while (!nums.empty()) {
            result += nums.top();
            nums.pop();
        }
        return result;
    }
};