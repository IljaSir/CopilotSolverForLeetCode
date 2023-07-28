class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        bool ret = false;
        for (int i = 0; i < nums.size(); ++i) {
            if (isPrime(nums[i])) {
                nums[i] -= 1;
                ret = true;
            }
        }
        return ret;
    }
    bool isPrime(int n) {
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    bool isSorted(vector<int>& nums) {
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    bool isStrictlyIncreasing(vector<int>& nums) {
        bool ret = false;
        while (!ret) {
            if (isSorted(nums)) {
                return true;
            }
            ret = primeSubOperation(nums);
        }
        return false;
    }
    bool isStrictlyIncreasing2(vector<int>& nums) {
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            if (nums[i] > nums[i + 1]) {
                if (isPrime(nums[i])) {
                    nums[i] -= 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    bool isStrictlyIncreasing3(vector<int>& nums) {
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            if (nums[i] > nums[i + 1]) {
                if (isPrime(nums[i])) {
                    nums[i] -= 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    bool isStrictlyIncreasing4(vector<int>& nums) {
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            if (nums[i] > nums[i + 1
    }
};