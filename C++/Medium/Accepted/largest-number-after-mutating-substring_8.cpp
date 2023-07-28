class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        int n = num.size();
        int i = 0;
        bool isChanged = false;
        while (i < n) {
            int digit = num[i] - '0';
            if (digit < change[digit]) {
                num[i] = change[digit] + '0';
                isChanged = true;
            } else if (digit > change[digit]) {
                if (isChanged) {
                    break;
                }
            }
            i++;
        }
        return num;
    }
};