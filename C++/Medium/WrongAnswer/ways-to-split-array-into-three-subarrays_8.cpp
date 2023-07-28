class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n+1, 0);
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int l = i;
            int r = n;
            while(l < r) {
                int mid = (l + r) / 2;
                if(prefix[mid] - prefix[i-1] < prefix[i-1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int left = l;
            if(left > n) {
                break;
            }
            l = i;
            r = n;
            while(l < r) {
                int mid = (l + r + 1) / 2;
                if(prefix[mid] - prefix[i-1] <= prefix[n] - prefix[mid]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int right = l;
            if(right < left) {
                continue;
            }
            ans += right - left + 1;
            ans %= 1000000007;
        }
        return ans;
    }
};