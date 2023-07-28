class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> result;
        for (int i = 0; i < digits.size(); i++) {
            for (int j = 0; j < digits.size(); j++) {
                for (int k = 0; k < digits.size(); k++) {
                    if (i != j && j != k && k != i) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (num % 2 == 0) {
                            result.push_back(num);
                        }
                    }
                }
            }
        }
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        return result;
    }
};