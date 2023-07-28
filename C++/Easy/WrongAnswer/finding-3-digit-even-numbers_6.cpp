class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> res;
        sort(digits.begin(), digits.end());
        for (int i = 0; i < digits.size(); ++i) {
            if (digits[i] % 2 == 1) continue;
            for (int j = 0; j < digits.size(); ++j) {
                if (i == j) continue;
                if (digits[j] % 2 == 1) continue;
                for (int k = 0; k < digits.size(); ++k) {
                    if (i == k || j == k) continue;
                    if (digits[k] % 2 == 1) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) res.push_back(num);
                }
            }
        }
        sort(res.begin(), res.end());
        res.erase(unique(res.begin(), res.end()), res.end());
        return res;
    }
};