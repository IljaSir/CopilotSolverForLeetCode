class Solution {
public:
    string countAndSay(int n) {
        
        if (n == 1) {
            return "1";
        }
        string prev = countAndSay(n - 1);
        string res;
        char cur = prev[0];
        int count = 1;
        for (int i = 1; i < prev.size(); i++) {
            if (prev[i] == cur) {
                count++;
            } else {
                res += to_string(count) + cur;
                cur = prev[i];
                count = 1;
            }
        }
        res += to_string(count) + cur;
        return res;
    }
};