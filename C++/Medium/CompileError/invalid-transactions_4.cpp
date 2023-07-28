class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> res;
        map<string, vector<pair<int, int>>> m;
        for (auto& t : transactions) {
            int i = 0;
            int n = t.length();
            string name;
            int time;
            int amount;
            string city;
            while (i < n) {
                int j = t.find(',', i);
                if (j == string::npos) {
                    j = n;
                }
                if (name.empty()) {
                    name = t.substr(i, j - i);
                } else if (time == 0) {
                    time = stoi(t.substr(i, j - i));
                } else if (amount == 0) {
                    amount = stoi(t.substr(i, j - i));
                } else {
                    city = t.substr(i, j - i);
                }
                i = j + 1;
            }
            if (amount > 1000) {
                res.push_back(t);
            }
            m[name].push_back({time, amount});
        }
        for (auto& [name, v] : m) {
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size(); ++i) {
                if (v[i].second > 1000) {
                    for (int j = 0; j < v.size(); ++j) {
                        if (j != i && abs(v[j].first - v[i].first) <= 60) {
                            res.push_back(name + "," + to_string(v[i].first) + "," + to_string(v[i].second) + "," + city);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
};