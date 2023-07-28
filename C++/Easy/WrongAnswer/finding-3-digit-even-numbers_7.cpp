class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> result;
        sort(digits.begin(), digits.end());
        for (int i = 0; i < digits.size(); ++i) {
            if (digits[i] % 2 != 0) continue;
            for (int j = i + 1; j < digits.size(); ++j) {
                if (digits[j] % 2 != 0) continue;
                for (int k = j + 1; k < digits.size(); ++k) {
                    if (digits[k] % 2 != 0) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    result.push_back(num);
                }
            }
        }
        return result;
    }
};