class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int count = 0;
        vector<vector<int>> charPos(26, vector<int>());
        for (int i = 0; i < s.length(); i++) {
            charPos[s[i] - 'a'].push_back(i);
        }
        for (auto word : words) {
            int pos = -1;
            bool isSub = true;
            for (auto c : word) {
                auto it = upper_bound(charPos[c - 'a'].begin(), charPos[c - 'a'].end(), pos);
                if (it == charPos[c - 'a'].end()) {
                    isSub = false;
                    break;
                }
                pos = *it;
            }
            if (isSub) {
                count++;
            }
        }
        return count;
    }
};