class Solution {
public:
    int splitNum(int num) {
        
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            sum += i;
        }
        return sum;
    }
    int splitNum2(int num) {
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            if (i > 0) {
                sum++;
            }
        }
        return sum;
    }
    int splitNum3(int num) {
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }
    int splitNum4(int num) {
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }
    int splitNum5(int num) {
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }
    int splitNum6(int num) {
        vector<int> digits(10, 0);
        int sum = 0;
        while (num) {
            digits[num % 10]++;
            num /= 10;
        }
        for (auto i : digits) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }
};