class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        vector<long long> result;
        if (num < 3) {
            return result;
        }
        
        long long n = num / 3;
        result.push_back(n);
        result.push_back(n + 1);
        result.push_back(n + 2);
        return result;
    }
};