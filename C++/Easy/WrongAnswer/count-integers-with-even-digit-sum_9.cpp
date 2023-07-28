class Solution {
public:
    int countEven(int num) {
        
        if (num < 10) return num / 2;
        int res = 0;
        int n = num;
        int d = 1;
        while (n >= 10) {
            n /= 10;
            d *= 10;
        }
        if (n % 2 == 0) {
            res += d / 2;
        } else {
            res += d / 2 - 1;
        }
        res += (n - 1) * d / 2;
        res += countEven(num % d);
        return res;
    }
    int findNumbers(vector<int>& nums) {
        int res = 0;
        for (int n : nums) {
            if (countEven(n) % 2 == 0) {
                res++;
            }
        }
        return res;
    }
};