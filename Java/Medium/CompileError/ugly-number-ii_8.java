class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;
        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }
        return next_ugly_no
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int nextUglyNumber = 1;
        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUglyNumber;
            if (nextUglyNumber == nextMultipleOf2) {
                i2 = i2 + 1;
                nextMultipleOf2 = ugly[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3 = i3 + 1;
                nextMultipleOf3 = ugly[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5 = i5 + 1;
                nextMultipleOf5 = ugly[i5] * 5;
            }
        }
        return nextUglyNumber;
    }
}