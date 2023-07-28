class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum <= threshold) return -1;
        int k = 1;
        while(k <= n) {
            sum = 0;
            for(int i = 0; i < k; i++) {
                sum += nums[i];
            }
            if(sum > threshold) return k;
            for(int i = k; i < n; i++) {
                sum -= nums[i-k];
                sum += nums[i];
                if(sum > threshold) return k;
            }
            k++;
        }
        return -1;
    }
};