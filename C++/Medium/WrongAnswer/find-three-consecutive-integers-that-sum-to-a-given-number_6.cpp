class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        vector<long long> ans;
        if (num < 3) {
            return ans;
        }
        long long a = num - 3, b = num - 2, c = num - 1;
        if (a % 3 == 0) {
            ans.push_back(a / 3);
            ans.push_back(a / 3 + 1);
            ans.push_back(a / 3 + 2);
        }
        return ans;
    }
};