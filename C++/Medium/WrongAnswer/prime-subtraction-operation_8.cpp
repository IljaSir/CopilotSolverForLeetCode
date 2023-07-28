class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            int p = 2;
            while (nums[i] > nums[i + 1]) {
                while (p < nums[i]) {
                    if (isPrime(p)) {
                        break;
                    }
                    p++;
                }
                if (nums[i] < p) {
                    return false;
                }
                nums[i] -= p;
            }
        }
        return true;
    }
    bool isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
};