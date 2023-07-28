class Solution {
public:
    string getPermutation(int n, int k) {
        
        vector<int> nums;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.push_back(i);
            fact *= i;
        }
        k--;
        string ans;
        for (int i = 0; i < n; i++) {
            fact = fact / (n - i);
            int index = k / fact;
            k = k % fact;
            ans.push_back(nums[index] + '0');
            nums.erase(nums.begin() + index);
        }
        return ans;
    }
};