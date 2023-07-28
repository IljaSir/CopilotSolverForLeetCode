class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        long long int n=arr.size();
        long long int sum=0;
        long long int maxsum=0;
        long long int minsum=0;
        long long int mod=1000000007;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            maxsum=max(maxsum,sum);
            minsum=min(minsum,sum);
        }
        long long int ans=0;
        if(k==1)
        {
            ans=maxsum;
        }
        else if(k==2)
        {
            ans=max(maxsum,sum-minsum);
        }
        else
        {
            ans=max(maxsum,sum-minsum);
            ans=max(ans,sum*(k-2)+maxsum);
        }
        return ans%mod;
    }
};