class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        long long i = 1;
        while (i * (i + 1) * (i + 2) < num) {
            i++;
        }
        if (i * (i + 1) * (i + 2) == num) {
            return {i, i + 1, i + 2};
        }
        return {};
    }
};