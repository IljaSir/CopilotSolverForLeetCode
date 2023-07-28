class Solution {
public:
    string getPermutation(int n, int k) {
        
        string result;
        vector<int> nums;
        for (int i = 1; i <= n; ++i) {
            nums.push_back(i);
        }
        int factorial = 1;
        for (int i = 1; i < n; ++i) {
            factorial *= i;
        }
        --k;
        for (int i = 0; i < n; ++i) {
            int index = k / factorial;
            result += to_string(nums[index]);
            nums.erase(nums.begin() + index);
            if (n - 1 - i > 0) {
                factorial /= n - 1 - i;
            }
            k -= index * factorial;
        }
        return result;
    }
};