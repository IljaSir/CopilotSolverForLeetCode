class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n), even(n);
        odd[0] = nums[0];
        even[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = even[i-1] + nums[i];
                odd[i] = odd[i-1];
            } else {
                odd[i] = odd[i-1] + nums[i];
                even[i] = even[i-1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftOdd = 0, leftEven = 0, rightOdd = 0, rightEven = 0;
            if (i > 0) {
                if (i % 2 == 0) {
                    leftOdd = odd[i-1];
                    leftEven = even[i-1];
                } else {
                    leftEven = odd[i-1];
                    leftOdd = even[i-1];
                }
            }
            if (i < n - 1) {
                if ((n - i - 1) % 2 == 0) {
                    rightOdd = odd[n-1] - odd[i];
                    rightEven = even[n-1] - even[i];
                } else {
                    rightEven = odd[n-1] - odd[i];
                    rightOdd = even[n-1] - even[i];
                }
            }
            if (leftOdd + rightOdd == leftEven + rightEven) {
                res++;
            }
        }
        return res;
    }
};