class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> ans;
        for (int i = 0; i < digits.size(); ++i) {
            for (int j = i + 1; j < digits.size(); ++j) {
                for (int k = j + 1; k < digits.size(); ++k) {
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        ans.push_back(num);
                    }
                }
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};