class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> result;
        int n = digits.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        result.push_back(num);
                    }
                }
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};