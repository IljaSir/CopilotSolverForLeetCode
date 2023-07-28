class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        
        vector<long long> res;
        // num = a + (a + 1) + (a + 2)
        // num = a + a + 1 + a + 2
        // num = 3a + 3
        // num - 3 = 3a
        // a = (num - 3) / 3
        long long a = (num - 3) / 3;
        if (a < 0) {
            return res;
        }
        res.push_back(a);
        res.push_back(a + 1);
        res.push_back(a + 2);
        return res;
    }
};