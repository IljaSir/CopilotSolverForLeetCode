class Solution {
public:
    vector<long long> handleQuery(vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& queries) {
        
        vector<long long> result;
        int n = nums1.size();
        vector<int> flip(n + 1, 0);
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums2[i];
        }
        for (auto& q : queries) {
            if (q[0] == 1) {
                int l = q[1];
                int r = q[2];
                flip[l]++;
                flip[r + 1]--;
            } else if (q[0] == 2) {
                int p = q[1];
                sum += p * (n - flip[0]);
                for (int i = 1; i <= n; i++) {
                    flip[i] += flip[i - 1];
                    sum += p * (flip[i] - flip[i - 1]) * (n - i);
                }
            } else {
                result.push_back(sum);
            }
        }
        return result;
    }
};