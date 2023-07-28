class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> ans;
        vector<int> s(score);
        sort(s.begin(), s.end());
        for (int i = 0; i < score.size(); i++) {
            int idx = lower_bound(s.begin(), s.end(), score[i]) - s.begin();
            if (idx == score.size() - 1) {
                ans.push_back("Gold Medal");
            } else if (idx == score.size() - 2) {
                ans.push_back("Silver Medal");
            } else if (idx == score.size() - 3) {
                ans.push_back("Bronze Medal");
            } else {
                ans.push_back(to_string(score.size() - idx));
            }
        }
        return ans;
    }
};