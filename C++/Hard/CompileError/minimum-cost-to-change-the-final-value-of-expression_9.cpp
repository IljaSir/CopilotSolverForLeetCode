class Solution {
public:
    int minOperationsToFlip(string expression) {
        
        int n = expression.size();
        vector<int> stk;
        vector<char> op;
        vector<int> val;
        for (int i = 0; i < n; i++) {
            if (expression[i] == '1' || expression[i] == '0') {
                val.puh_back(expressioni] - '');
            } else if (expression[i] == '(') {
                op.push_back(expression[i)
            } else if (expression[i] == ')') {
                while (op.back() != '(') {
                    calc(val, op);
                }
                op.pop_back();
            } else {
                while (op.size() && op.back() != '(') {
                    calc(val, op);
                }
                op.push_back(expression[i]);
            }
        }
        while (op.size()) {
            calc(val, op);
        }
        return val[0];
    }
    void calc(vector<int> &val, vector<char> &op) {
        int b = val.back();
        val.pop_back();
        int a = val.back();
        val.pop_back();
        char o = op.back();
        op.pop_back();
        if (o == '&') {
            val.push_back(a & b);
        } else {
            val.push_back(a | b);
        }

        int n = expression.length();
        vector<int> nums(n);
        vector<char> ops(n);
        int num = 0;
        int op = 0;
        for (int i = 0; i < n; ++i) {
            if (expression[i] == '0' || expression[i] == '1') {
                nums[num++] = expression[i] - '0';
            } else if (expression[i] == '&' || expression[i] == '|') {
                ops[op++] = expression[i];
            } else if (expression[i] == '(') {
                ops[op++] = expression[i];
            } else if (expression[i] == ')') {
                while (ops[op - 1] != '(') {
                    calc(nums, num, ops, op);
                }
                --op;
            }
        }
        while (op > 0) {
            calc(nums, num, ops, op);
        }
        return nums[0];
    }
};