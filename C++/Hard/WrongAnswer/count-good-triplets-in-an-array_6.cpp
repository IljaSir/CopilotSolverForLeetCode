class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> c1(n), c2(n);
        for (int i = 0; i < n; i++) {
            c1[nums1[i]].push_back(i);
            c2[nums2[i]].push_back(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = nums1[i], y = nums1[j];
                if (x > y) swap(x, y);
                int l = lower_bound(c2[x].begin(), c2[x].end(), i) - c2[x].begin();
                int r = upper_bound(c2[y].begin(), c2[y].end(), j) - c2[y].begin();
                ans += r - l;
            }
        }
        return ans;
    }
};