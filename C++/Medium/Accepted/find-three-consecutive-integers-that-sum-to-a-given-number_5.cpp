class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        vector<long long> result;
        long long x = num - 3;
        if (x % 3 == 0) {
            x /= 3;
            result.push_back(x);
            result.push_back(x + 1);
            result.push_back(x + 2);
        }
        return result;
    }
};