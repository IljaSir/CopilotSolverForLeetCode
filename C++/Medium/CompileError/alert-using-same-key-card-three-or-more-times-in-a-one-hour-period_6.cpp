class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        sort(res.begin(), res.end());
re
        unordered_map<string, vector<int>> m;
        for (int i = 0; i < keyName.size(); i++) {
            m[keyName[i]].push_back(convert(keyTime[i]));
        }
        vector<string> res;
        for (auto& p : m) {
            sort(p.second.begin(), p.second.end());
            for (int i = 2; i < p.second.size(); i++) {
                if (p.second[i] - p.second[i - 2] <= 60) {
                    res.push_back(p.first);
                    break;
                }
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};