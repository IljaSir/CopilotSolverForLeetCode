class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd(n);
        vector<int> even(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i % 2 == 0) {
                even[i] = sum;
                odd[i] = i > 0 ? odd[i - 1] : 0;
            } else {
                odd[i] = sum;
                even[i] = i > 0 ? even[i - 1] : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int s1 = odd[i] - (i > 0 ? odd[i - 1] : 0);
            int s2 = even[i] - (i > 0 ? even[i - 1] : 0);
            int s3 = even[n - 1] - even[i];
            int s4 = odd[n - 1] - odd[i];
            if (s1 + s3 == s2 + s4) {
                ans++;
            }
        }
        return ans;
    }
};