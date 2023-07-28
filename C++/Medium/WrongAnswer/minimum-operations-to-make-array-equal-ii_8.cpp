class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        int m = nums2.size();
        if (n * m < k) return -1;
        vector<int> v;
        for (int i = 0; i < n; i++) {
            v.push_back(nums1[i] - 1);
        }
        for (int i = 0; i < m; i++) {
            v.push_back(6 - nums2[i]);
        }
        sort(v.begin(), v.end());
        long long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += v[i];
        }
        long long ans = sum;
        for (int i = k; i < n + m; i++) {
            sum += v[i];
            sum -= v[i - k];
            ans = min(ans, sum);
        }
        return ans;
    }
};