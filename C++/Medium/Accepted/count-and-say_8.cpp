class Solution {
public:
    string countAndSay(int n) {
        
        if (n == 1) {
            return "1";
        }
        string prev = countAndSay(n - 1);
        string res = "";
        int i = 0;
        int len = prev.length();
        while (i < len) {
            int j = i + 1;
            while (j < len && prev[j] == prev[i]) {
                j++;
            }
            res += to_string(j - i) + prev[i];
            i = j;
        }
        return res;
    }
};