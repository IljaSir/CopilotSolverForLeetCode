class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        map<string, vector<int>> m;
        int n = keyName.size();
        for (int i = 0; i < n; ++i) {
            int t = stoi(keyTime[i].substr(0, 2)) * 60 + stoi(keyTime[i].substr(3, 2));
            m[keyName[i]].push_back(t);
        }
        vector<string> ans;
        for (auto& [name, times]: m) {
            sort(times.begin(), times.end());
            int m = times.size();
            for (int i = 0; i + 2 < m; ++i) {
                if (times[i + 2] - times[i] <= 60) {
                    ans.push_back(name);
                    break;
                }
            }
        }
        return ans;
    }
};