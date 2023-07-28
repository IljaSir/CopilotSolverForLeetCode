class Solution {
public:
    string largestGoodInteger(string num) {
        
        int count[10] = {0};
        for (auto c : num) count[c - '0']++;
        for (int i = 9; i > 0; i--) {
            if (count[i] >= 3) {
                string res;
                while (count[i]--) res += to_string(i);
                return res;
            }
        }
        return "";
    }
};