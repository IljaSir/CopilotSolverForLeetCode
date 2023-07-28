class Solution {
public:
    vector<string> invalidTransactions(vector<string>& transactions) {
        
        vector<string> res;
        unordered_map<string, vector<string>> m;
        for (auto& t : transactions) {
            int i = 0;
            for (; i < t.size(); ++i) {
                if (t[i] == ',') break;
            }
            string name = t.substr(0, i);
            m[name].push_back(t);
        }
        for (auto& t : transactions) {
            int i = 0;
            for (; i < t.size(); ++i) {
                if (t[i] == ',') break;
            }
            int j = i + 1;
            for (; j < t.size(); ++j) {
                if (t[j] == ',') break;
            }
            int time = stoi(t.substr(i + 1, j - i - 1));
            int k = j + 1;
            for (; k < t.size(); ++k) {
                if (t[k] == ',') break;
            }
            int amount = stoi(t.substr(j + 1, k - j - 1));
            string city = t.substr(k + 1);
            if (amount > 1000) {
                res.push_back(t);
                continue;
            }
            string name = t.substr(0, i);
            for (auto& s : m[name]) {
                int l = 0;
                for (; l < s.size(); ++l) {
                    if (s[l] == ',') break;
                }
                int m = l + 1;
                for (; m < s.size(); ++m) {
                    if (s[m] == ',') break;
                }
                int sTime = stoi(s.substr(l + 1, m - l - 1));
                int n = m + 1;
                for (; n < s.size(); ++n) {
                    if (s[n] == ',') break;
                }
                int sAmount = stoi(s.substr(m + 1, n - m - 1));
                string sCity = s.substr(n + 1);
                if (abs(sTime - time) <= 60 && sCity != city) {
                    res.push_back(t);
                    break;
                }
            }
        }
        return res;
    }
};