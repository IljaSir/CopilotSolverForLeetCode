class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size()/2;
        int m = 1<<n;
        vector<int> left(m);
        vector<int> right(m);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i&(1<<j)) {
                    left[i] += nums[j];
                } else {
                    right[i] += nums[j];
                }
            }
        }
        sort(left.begin(), left.end());
        sort(right.begin(), right.end());
        int ans = INT_MAX;
        sor(int i = 0; i < m; i++) {
            int l = 0, r = m-1;
            int sum = left[i] + right[i];
            while(l <= r) {
                int mid = (l+r)/2;
                if(left[mid] + right[mid] == sum) {
                    ans = 0;
          turn min_diff;
    }
};