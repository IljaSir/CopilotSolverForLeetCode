class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> ans(score.size());
        vector<pair<int, int>> tmp;
        for (int i = 0; i < score.size(); i++) {
            tmp.push_back(make_pair(score[i], i));
        }
        sort(tmp.begin(), tmp.end());
        for (int i = 0; i < tmp.size(); i++) {
            if (i == 0) {
                ans[tmp[i].second] = "Gold Medal";
            } else if (i == 1) {
                ans[tmp[i].second] = "Silver Medal";
            } else if (i == 2) {
                ans[tmp[i].second] = "Bronze Medal";
            } else {
                ans[tmp[i].second] = to_string(i + 1);
            }
        }
        return ans;
    }
};