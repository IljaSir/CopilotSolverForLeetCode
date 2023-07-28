class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        vector<string> ans;
        if(score.size() == 0) return ans;
        if(score.size() == 1) {
            ans.push_back("Gold Medal");
            return ans;
        }
        if(score.size() == 2) {
            if(score[0] > score[1]) {
                ans.push_back("Gold Medal");
                ans.push_back("Silver Medal");
            } else {
                ans.push_back("Silver Medal");
                ans.push_back("Gold Medal");
            }
            return ans;
        }
        if(score.size() == 3) {
            if(score[0] > score[1]) {
                if(score[0] > score[2]) {
                    ans.push_back("Gold Medal");
                    if(score[1] > score[2]) {
                        ans.push_back("Silver Medal");
                        ans.push_back("Bronze Medal");
                    } else {
                        ans.push_back("Bronze Medal");
                        ans.push_back("Silver Medal");
                    }
                } else {
                    ans.push_back("Bronze Medal");
                    ans.push_back("Gold Medal");
                    ans.push_back("Silver Medal");
                }
            } else {
                if(score[1] > score[2]) {
                    ans.push_back("Silver Medal");
                    if(score[0] > score[2]) {
                        ans.push_back("Gold Medal");
                        ans.push_back("Bronze Medal");
                    } else {
                        ans.push_back("Bronze Medal");
                        ans.push_back("Gold Medal");
                    }
                } else {
                    ans.push_back("Bronze Medal");
                    ans.push_back("Silver Medal");
                    ans.push_back("Gold Medal");
                }
            }
            return ans;
        }
        vector<int> s = score;
        sort(s.begin(), s.end(), greater<int>());
        for(int i = 0; i < score.size(); i++) {
            for(int j = 0; j < s.size(); j++) {
                if(score[i] == s[j]) {
                    if(j == 0) ans.push_back("Gold Medal");
                    else if(j == 1) ans.push_back("Silver Medal");
                    else if(j == 2) ans.push_back("Bronze Medal");
                    else ans.push_back(to_string(j + 1));
                }
            }
        }
        return ans;
    }
};