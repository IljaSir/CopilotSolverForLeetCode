class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int q = queries.size();
        vector<int> res(q, -1);
        for (int i = 0; i < q; i++) {
            queries[i].push_back(i);
        }
        sort(queries.begin(), queries.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        int j = 0;
        for (int i = 0; i < q; i++) {
            while (j < n && nums[j] <= queries[i][1]) {
                j++;
            }
            if (j == 0) {
                continue;
            }
            int cur = 0;
            for (int k = 30; k >= 0; k--) {
                int bit = (queries[i][0] >> k) & 1;
                if (bit == 0) {
                    if (cur * 2 + 1 < j && nums[cur * 2 + 1] <= queries[i][1]) {
                        cur = cur * 2 + 1;
                    } else if (cur * 2 + 2 < j && nums[cur * 2 + 2] <= queries[i][1]) {
                        cur = cur * 2 + 2;
                    } else {
                        break;
                    }
                } else {
                    if (cur * 2 + 2 < j && nums[cur * 2 + 2] <= queries[i][1]) {
                        cur = cur * 2 + 2;
                    } else if (cur * 2 + 1 < j && nums[cur * 2 + 1] <= queries[i][1]) {
                        cur = cur * 2 + 1;
                    } else {
                        break;
                    }
                }
            }
            res[queries[i][2]] = nums[cur] ^ queries[i][0];
        }
        return res;
    }
};