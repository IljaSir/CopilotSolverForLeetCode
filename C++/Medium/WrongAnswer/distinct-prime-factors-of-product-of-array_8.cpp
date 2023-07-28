class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] > max)
                max = nums[i];
        }
        int count = 0;
        for(int i = 2; i <= max; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] % i == 0)
                    c++;
            }
            if(c > 0)
                count++;
        }
        return count;
    }
};