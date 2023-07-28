class Solution {
public:
    string largestMultipleOfThree(vector<int>& digits) {
        
        int sum = 0;
        vector<int> remainders[3];
        for (int i = 0; i < digits.size(); i++) {
            sum += digits[i];
            remainders[digits[i] % 3].push_back(digits[i]);
        }
        int remainder = sum % 3;
        if (remainder == 1) {
            if (remainders[1].size() > 0) {
                remove(remainders[1].begin(), remainders[1].end(), *min_element(remainders[1].begin(), remainders[1].end()));
            } else if (remainders[2].size() > 1) {
                remove(remainders[2].begin(), remainders[2].end(), *min_element(remainders[2].begin(), remainders[2].end()));
                remove(remainders[2].begin(), remainders[2].end(), *min_element(remainders[2].begin(), remainders[2].end()));
            } else {
                return "";
            }
        } else if (remainder == 2) {
            if (remainders[2].size() > 0) {
                remove(remainders[2].begin(), remainders[2].end(), *min_element(remainders[2].begin(), remainders[2].end()));
            } else if (remainders[1].size() > 1) {
                remove(remainders[1].begin(), remainders[1].end(), *min_element(remainders[1].begin(), remainders[1].end()));
                remove(remainders[1].begin(), remainders[1].end(), *min_element(remainders[1].begin(), remainders[1].end()));
            } else {
                return "";
            }
        }
        string result = "";
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < remainders[i].size(); j++) {
                result += remainders[i][j] + '0';
            }
        }
        sort(result.begin(), result.end(), greater<int>());
        if (result[0] == '0') {
            return "0";
        }
        return result;
    }
};