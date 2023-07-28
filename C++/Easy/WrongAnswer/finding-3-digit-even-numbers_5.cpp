class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> result;
        sort(digits.begin(), digits.end());
        do {
            int num = 0;
            for (int i = 0; i < 3; ++i) {
                num = num * 10 + digits[i];
            }
            if (num % 2 == 0) {
                result.push_back(num);
            }
        } while (next_permutation(digits.begin(), digits.end()));
        return result;
    }
};