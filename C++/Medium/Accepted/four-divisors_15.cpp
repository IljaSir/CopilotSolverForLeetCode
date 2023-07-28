class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        
        int sum = 0;
        for (int i: nums) {
            int c = 0;
            int d = 0;
            for (int k = 1; k*k <= i; k++) {
                if (i%k == 0) {
                    if (k*k == i) {
                        d += k;
                        c++;
                    } else {
                        d += k;
                        d += i/k;
                        c += 2;
                    }
                }
            }
            if (c == 4) sum += d;
        }
        return sum;
    }
};