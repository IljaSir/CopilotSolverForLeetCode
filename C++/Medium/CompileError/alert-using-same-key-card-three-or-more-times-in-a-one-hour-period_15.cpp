class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        vector<string> result;
        unordered_map<string, vector<int>> m;
        for (int i = 0; i < keyName.size(); ++i) {
            m[keyName[i]].push_back(time_to_int(keyTime[i]));
        }
        for (auto& p : m) {
            sort(p.second.begin(), p.second.end());
            for (int i = 0; i + 2 < p.second.size(); ++i) {
                if (p.second[i + 2] - p.second[i] <= 60) {
                    result.push_back(p.first);
                    break;
                }
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};