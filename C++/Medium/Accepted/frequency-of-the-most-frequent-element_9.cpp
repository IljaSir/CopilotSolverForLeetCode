class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int maxFreq = 0;
        int i = 0;
        long long sum = 0;
        for(int j = 0; j < n; j++){
            sum += nums[j];
            while(sum + k < (long long)(j-i+1)*nums[j]){
                sum -= nums[i];
                i++;
            }
            maxFreq = max(maxFreq, j-i+1);
        }
        return maxFreq;
    }
};