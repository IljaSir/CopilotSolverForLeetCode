class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        vector<int> preSum(n+1,0);
        for(int i = 1; i <= n; ++i){
            preSum[i] = preSum[i-1] + arr[i-1];
        }
        int l = 0, r = arr[n-1];
        int ans = 0;
        int diff = INT_MAX;
        while(l <= r){
            int mid = l + (r-l)/2;
            auto it = upper_bound(arr.begin(), arr.end(), mid);
            int idx = it - arr.begin();
            int curSum = preSum[idx] + (n-idx)*mid;
            if(curSum == target){
                return mid;
            }
            else if(curSum < target){
                l = mid + 1;
                if(target - curSum < diff){
                    diff = target - curSum;
                    ans = mid;
                }
                else if(target - curSum == diff){
                    ans = min(ans, mid);
                }
            }
            else{
                r = mid - 1;
                if(curSum - target < diff){
                    diff = curSum - target;
                    ans = mid;
                }
                else if(curSum - target == diff){
                    ans = min(ans, mid);
                }
            }
        }
        return ans;
    }
};