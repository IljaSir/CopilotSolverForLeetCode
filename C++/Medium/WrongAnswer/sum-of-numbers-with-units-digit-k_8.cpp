class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        int ans = 0;
        while (num > 0) {
            if (num >= k) {
                num -= k;
                ans++;
            } else {
                if (num + 10 - k <= 9) {
                    num = 0;
                    ans++;
                } else {
                    num = 10 - num;
                    ans += 2;
                }
            }
        }
        return ans;
    }
    int sumOfDigits(vector<int>& A) {
        int min_val = INT_MAX;
        for (int i = 0; i < A.size(); i++) {
            min_val = min(min_val, A[i]);
        }
        return minimumNumbers(min_val, 1);
    }
};