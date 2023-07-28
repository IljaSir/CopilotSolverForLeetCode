class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int low = nums[0];
        int high = nums[n-1];
        int sum = 0;
        for(int i=0;i<n-1;i++) {
            sum += abs(nums[i]-nums[i+1]);
        }
        int ans = sum;
        for(int i=0;i<n-1;i++) {
            int l = nums[i];
            int h = nums[i+1];
            int s = sum;
            s -= abs(l-h);
            s += abs(low-h);
            s += abs(l-high);
            ans = min(ans,s);
            low = min(low,l);
            high = max(high,h);
        }
        return ans;
    }
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += abs(nums1[i]-nums2[i]);
        }
        int ans = sum;
        ans -= minimizeSum(nums1);
        ans -= minimizeSum(nums2);
        ans = (ans+2e9)%1000000007;
        return ans;
    }
};