class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        vector<int> result = {0, 0};
        int n = words.size();
        vector<vector<int>> groups;
        for (int i = 0; i < n; i++) {
            int wordLen = words[i].size();
            bool isGrouped = false;
            for (int j = 0; j < groups.size(); j++) {
                for (int k = 0; k < groups[j].size(); k++) {
                    int groupLen = words[groups[j][k]].size();
                    if (wordLen == groupLen) {
                        int diff = words[i][0] - words[groups[j][k]][0];
                        if (diff < 0) diff += 26;
                        bool isSame = true;
                        for (int l = 0; l < wordLen; l++) {
                            if (words[i][l] != words[groups[j][k]][l] - diff + 26) {
                                isSame = false;
                                break;
                            }
                        }
                        if (isSame) {
                            groups[j].push_back(i);
                            isGrouped = true;
                            break;
                        }
                    }
                }
                if (isGrouped) break;
            }
            if (!isGrouped) {
                groups.push_back({i});
            }
        }
        result[0] = groups.size();
        for (int i = 0; i < groups.size(); i++) {
            result[1] = max(result[1], (int)groups[i].size());
        }
        return result;
    }
};