class Solution {
public:
    string largestMultipleOfThree(vector<int>& digits) {
        
        vector<int> sum(3, 0);
        int total = 0;
        for (auto d : digits) {
            sum[d % 3]++;
            total += d;
        }
        if (total % 3 == 1) {
            if (sum[1]) sum[1]--;
            else {
                sum[2] -= 2;
            }
        }
        if (total % 3 == 2) {
            if (sum[2]) sum[2]--;
            else {
                sum[1] -= 2;
            }
        }
        if (sum[0] == digits.size()) return "0";
        string ret;
        for (int i = 9; i >= 0; i--) {
            if (i % 3 == 0) {
                while (sum[0]--) {
                    ret += to_string(i);
                }
            } else if (i % 3 == 1) {
                while (sum[1]--) {
                    ret += to_string(i);
                }
            } else {
                while (sum[2]--) {
                    ret += to_string(i);
                }
            }
        }
        return ret;
    }
};