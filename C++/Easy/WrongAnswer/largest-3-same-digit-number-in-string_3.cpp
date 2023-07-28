class Solution {
public:
    string largestGoodInteger(string num) {
        
        int i = 0;
        while (i < num.size() - 2) {
            if (num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
                int j = i + 3;
                while (j < num.size() && num[j] == num[i]) ++j;
                for (int k = i; k < j; ++k) num[k] = '9';
                i = j;
            } else {
                ++i;
            }
        }
        return num;
    }
};