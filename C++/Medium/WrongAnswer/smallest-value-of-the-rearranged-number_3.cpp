class Solution {
public:
    long long smallestNumber(long long num) {
        
        if(num < 10) return num;
        vector<int> digits;
        while(num) {
            digits.push_back(num % 10);
            num /= 10;
        }
        sort(digits.begin(), digits.end());
        long long res = 0;
        for(int d : digits) {
            res = res * 10 + d;
        }
        return res;
    }
};