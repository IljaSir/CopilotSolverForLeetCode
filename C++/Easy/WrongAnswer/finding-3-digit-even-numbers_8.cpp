class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> result;
        int size = digits.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    sum = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (sum % 2 == 0) {
                        result.push_back(sum);
                    }
                }
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};