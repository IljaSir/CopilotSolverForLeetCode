class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> res;
        unordered_map<string, vector<vector<string>>> m;
        for (auto& t : transactions) {
            int i = t.find(',');
            int j = t.find(',', i + 1);
            int k = t.find(',', j + 1);
            m[t.substr(0, i)].push_back({t.substr(i + 1, j - i - 1), t.substr(j + 1, k - j - 1), t.substr(k + 1)});
        }
        for (auto& v : m) {
            for (int i = 0; i < v.second.size(); i++) {
                if (stoi(v.second[i][1]) > 1000) {
                    res.push_back(v.first + ',' + v.second[i][0] + ',' + v.second[i][1] + ',' + v.second[i][2]);
                    continue;
                }
                for (int j = 0; j < v.second.size(); j++) {
                    if (i != j && v.second[i][2] != v.second[j][2] && abs(stoi(v.second[i][0]) - stoi(v.second[j][0])) <= 60) {
                        res.push_back(v.first + ',' + v.second[i][0] + ',' + v.second[i][1] + ',' + v.second[i][2]);
                        break;
                    }
                }
            }
        }
        return res;
    }
};