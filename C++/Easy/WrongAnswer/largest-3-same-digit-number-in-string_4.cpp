class Solution {
public:
    string largestGoodInteger(string num) {
        
        int count[10] = {0};
        for (char c : num) {
            count[c - '0']++;
        }
        int max = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] >= 3 && max < i) {
                max = i;
            }
        }
        if (max == 0) return "";
        string res = "";
        for (int i = 0; i < count[max]; i++) {
            res += to_string(max);
        }
        return res;
    }
};