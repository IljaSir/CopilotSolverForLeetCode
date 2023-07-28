class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int minDiff = INT_MAX;
        vector<int> sum(n+1, 0);
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i = 0; i < n-1; i++){
            int l = i+1, r = n-1;
            while(l < r){
                int mid = (l+r)/2;
                int a = sum[mid+1] - sum[i+1];
                int b = sum[n] - sum[mid+1];
                if(a > b){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            int a = sum[l] - sum[i+1];
            int b = sum[n] - sum[l];
            int diff = abs(a*l - b*(i+1));
            if(diff < minDiff){
                ans = i;
                minDiff = diff;
            }
        }
        return ans;
    }
};