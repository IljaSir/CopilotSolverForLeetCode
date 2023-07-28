class Solution {
    public boolean isHappy(int n) {
        
        int sum = 0;
        int[] arr = new int[100];
        int i = 0;
        while (n != 1) {
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            for (int j = 0; j < i; j++) {
                if (arr[j] == sum) {
                    return false;
                }
            }
            arr[i++] = sum;
            n = sum;
        }
        return true;
    }
}