class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> res;
        unordered_map<string, vector<string>> mp;
        for (auto &t : transactions) {
            int i = 0;
            string name, time, amount, city;
            while (i < t.size() && t[i] != ',') name += t[i++];
            i++;
            while (i < t.size() && t[i] != ',') time += t[i++];
            i++;
            while (i < t.size() && t[i] != ',') amount += t[i++];
            i++;
            while (i < t.size() && t[i] != ',') city += t[i++];
            mp[name].push_back(time + "," + amount + "," + city);
        }
        for (auto &p : mp) {
            vector<string> &v = p.second;
            sort(v.begin(), v.end(), [](const string &a, const string &b) {
                int i = 0;
                while (i < a.size() && a[i] != ',') i++;
                int j = 0;
                while (j < b.size() && b[j] != ',') j++;
                return stoi(a.substr(0, i)) < stoi(b.substr(0, j));
            });
            for (int i = 0; i < v.size(); i++) {
                int j = i + 1;
                while (j < v.size()) {
                    int k = 0;
                    while (k < v[i].size() && v[i][k] != ',') k++;
                    int l = 0;
                    while (l < v[j].size() && v[j][l] != ',') l++;
                    if (stoi(v[j].substr(l + 1)) > 1000) {
                        res.push_back(p.first + "," + v[j]);
                        break;
                    }
                    if (stoi(v[j].substr(0, l)) - stoi(v[i].substr(0, k)) > 60) break;
                    if (v[i].substr(k + 1) != v[j].substr(l + 1)) {
                        res.push_back(p.first + "," + v[i]);
                        res.push_back(p.first + "," + v[j]);
                        break;
                    }
                    j++;
                }
                if (j == v.size() && stoi(v[i].substr(k + 1)) > 1000) {
    }
};