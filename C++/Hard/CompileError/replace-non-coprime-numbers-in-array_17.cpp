class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> result(nums.size(), 1);
        for (int i = 0; i < nums.size(); ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
                if (num % j == 0) {
                    int a = j, b = num / j;
                    if (a != b) {
                        if (isPrime(a) && isPrime(b)) {
                            result[i] = num;
                            break;
                        }
                    } else {
                        if (isPrime(a)) {
                            result[i] = num;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
};