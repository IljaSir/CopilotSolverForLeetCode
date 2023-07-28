class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (!isPrime(nums[i+1])) {
                    if (nums[i+1] == 1) {
                        nums[i+1] = 2;
                        continue;
                    }
                    return false;
                }
                nums[i] -= nums[i+1];
                i = -1;
            }
        }
        return true;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i*i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}