class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<long long> sum(n+1,0);
        for(int i=1;i<=n;i++)
            sum[i] = sum[i-1] + nums[i-1];
        //for(int i=0;i<=n;i++)
        //    cout << sum[i] << " ";
        //cout << endl;
        for(int i=1;i<=n-k+1;i++){
            long long tmp = 0;
            for(int j=i;j<=n-k+1;j++){
                if(sum[j+k-1]-sum[j-1] > tmp)
                    tmp = sum[j+k-1]-sum[j-1];
            }
            if(tmp > ans)
                ans = tmp;
        }
        return ans;
    }
};