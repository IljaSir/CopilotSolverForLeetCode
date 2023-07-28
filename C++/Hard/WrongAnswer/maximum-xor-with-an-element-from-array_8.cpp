class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> answer(m);
        vector<int> idx(m);
        iota(idx.begin(), idx.end(), 0);
        sort(idx.begin(), idx.end(), [&queries](int i, int j){
            return queries[i][1] < queries[j][1];
        });
        sort(nums.begin(), nums.end());
        vector<bool> used(n);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && nums[j] <= queries[idx[i]][1]) {
                used[j] = true;
                j++;
            }
            if (j == 0) {
                answer[idx[i]] = -1;
                continue;
            }
            int cur = 0;
            for (int k = 30; k >= 0; k--) {
                int bit = (queries[idx[i]][0] >> k) & 1;
                int next = cur | (bit ^ 1);
                bool found = false;
                for (int l = 0; l < j; l++) {
                    if (used[l] && ((nums[l] >> k) & 1) == next) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    cur = next;
                } else {
                    cur = next ^ 1;
                }
            }
            answer[idx[i]] = queries[idx[i]][0] ^ cur;
        }
        return answer;
    }
};