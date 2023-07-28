class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 != 0) odd++;
                else even++;
            } else {
                if (nums[i] % 2 != 0) even++;
                else odd++;
            }
        }
        return min(odd, even);
    }
};