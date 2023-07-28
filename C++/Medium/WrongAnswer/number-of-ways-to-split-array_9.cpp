class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        long long int n = nums.size();
        vector<long long int> preSum(n, 0);
        preSum[0] = nums[0];
        for(long long int i = 1; i < n; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        long long int ans = 0;
        long long int mod = 1e9 + 7;
        for(long long int i = 0; i < n-2; i++){
            long long int l = i+1;
            long long int r = n-1;
            long long int mid = 0;
            while(l <= r){
                mid = (l+r)/2;
                long long int sum1 = preSum[mid] - preSum[i];
                long long int sum2 = preSum[n-1] - preSum[mid];
                if(sum1 > sum2){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            ans = (ans + (mid - i)) % mod;
        }
        return ans;
    }
};