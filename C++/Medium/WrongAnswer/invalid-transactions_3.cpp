class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> ans;
        map<string, vector<tuple<string, string, string, string>>> m;
        for (auto& t : transactions) {
            auto i1 = t.find(',');
            auto i2 = t.find(',', i1 + 1);
            auto i3 = t.find(',', i2 + 1);
            m[t.substr(i1 + 1, i2 - i1 - 1)].emplace_back(t.substr(0, i1), t.substr(i1 + 1, i2 - i1 - 1), t.substr(i2 + 1, i3 - i2 - 1), t.substr(i3 + 1));
        }
        for (auto& [k, v] : m) {
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size(); ++i) {
                if (stoi(get<2>(v[i])) > 1000) {
                    ans.push_back(get<0>(v[i]) + ',' + get<1>(v[i]) + ',' + get<2>(v[i]) + ',' + get<3>(v[i]));
                    continue;
                }
                for (int j = i + 1; j < v.size(); ++j) {
                    if (get<3>(v[i]) != get<3>(v[j]) && abs(stoi(get<1>(v[i])) - stoi(get<1>(v[j]))) <= 60) {
                        ans.push_back(get<0>(v[i]) + ',' + get<1>(v[i]) + ',' + get<2>(v[i]) + ',' + get<3>(v[i]));
                        ans.push_back(get<0>(v[j]) + ',' + get<1>(v[j]) + ',' + get<2>(v[j]) + ',' + get<3>(v[j]));
                    }
                }
            }
        }
        return ans;
    }
};