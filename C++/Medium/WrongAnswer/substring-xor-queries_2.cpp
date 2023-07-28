class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.length();
        vector<int> xorSum(n + 1);
        for (int i = 0; i < n; ++i) {
            xorSum[i + 1] = xorSum[i] ^ (s[i] - '0');
        }
        vector<vector<int>> ans;
        for (const auto& q : queries) {
            int first = q[0], second = q[1];
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if ((xorSum[mid + 1] ^ first) == second) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == n || (xorSum[left + 1] ^ first) != second) {
                ans.push_back({-1, -1});
            } else {
                ans.push_back({left, left + 1});
            }
        }
        return ans;
    }
};