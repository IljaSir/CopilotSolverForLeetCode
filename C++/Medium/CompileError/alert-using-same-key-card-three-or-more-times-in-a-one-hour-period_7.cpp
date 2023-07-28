class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        map<string, vector<int>> m;
        for (int i = 0; i < keyName.size(); i++) {
            m[keyName[i]].push_back(toMin(keyTime[i]));
        }
        vector<string> res;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (check(it->second)) {
                res.push_back(it->first);
            }
        }
        return res;
    }or<string> ret;
        undered_map, vector<int>m;
        fo (int i = 0; i < keyNam.ize(); ++i) {
            m[keyName[i]].psh_back(toMin(keyTime[i]));
        }
        for (auto& it : m) {
            vector<int>& v = it.second;
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size() - 2; ++i) {
                if (v[i + 2] - v[i] <= 60) {
                    ret.push_back(it.first);
                    break;
                }
            }
        }
        sort(ret.begin(), ret.end());
        return ret;
    }
};