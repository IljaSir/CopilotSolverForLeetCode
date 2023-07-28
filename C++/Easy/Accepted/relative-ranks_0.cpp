class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        int n = score.size();
        vector<string> ans(n);
        vector<int> rank(n);
        for (int i = 0; i < n; ++i) {
            rank[i] = i;
        }
        sort(rank.begin(), rank.end(), [&](int a, int b) { return score[a] > score[b]; });
        for (int i = 0; i < n; ++i) {
            string s;
            switch (i) {
                case 0:
                    s = "Gold Medal";
                    break;
                case 1:
                    s = "Silver Medal";
                    break;
                case 2:
                    s = "Bronze Medal";
                    break;
                default:
                    s = to_string(i + 1);
                    break;
            }
            ans[rank[i]] = s;
        }
        return ans;
    }
};