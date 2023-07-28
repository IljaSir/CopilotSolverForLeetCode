class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        vector<long long> res;
        if (num < 3)
            return res;
        long long a = num / 3;
        long long b = a + 1;
        long long c = b + 1;
        if (a % 2 == 1 && b % 2 == 0 && c % 2 == 1)
            res = {a - 1, b, c - 1};
        else if (a % 2 == 0 && b % 2 == 1 && c % 2 == 0)
            res = {a - 1, b, c - 1};
        else if (a % 2 == 1 && b % 2 == 1 && c % 2 == 1)
            res = {a - 1, b, c - 1};
        else if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0)
            res = {a - 1, b, c - 1};
        return res;
    }
};