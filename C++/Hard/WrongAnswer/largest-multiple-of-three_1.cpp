class Solution {
public:
    string largestMultipleOfThree(vector<int>& digits) {
        
        sort(digits.begin(), digits.end(), greater<int>());
        int sum = accumulate(digits.begin(), digits.end(), 0);
        if (sum % 3 == 1) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 1) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 2) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 2) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
        } else if (sum % 3 == 2) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 2) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 1) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
            for (int i = 0; i < digits.size(); i++) {
                if (digits[i] % 3 == 1) {
                    digits.erase(digits.begin() + i);
                    break;
                }
            }
        }
        string res = "";
        for (int i = 0; i < digits.size(); i++) {
            res += to_string(digits[i]);
        }
        return res;
    }
};