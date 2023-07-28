class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        
        int sum = 0;
        int min1 = INT_MAX, min2 = INT_MAX;
        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) {
                min2 = min(min2, min1 + n);
                min1 = min(min1, n);
            } else if (n % 3 == 2) {
                min1 = min(min1, min2 + n);
                min2 = min(min2, n);
            }
        }
        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            return sum - min1;
        } else {
            return sum - min2;
        }
    }
};