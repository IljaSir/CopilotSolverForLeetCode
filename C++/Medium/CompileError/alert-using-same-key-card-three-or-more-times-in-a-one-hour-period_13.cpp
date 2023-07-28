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
    }
    
    bool check(vector<int> &v) {
        sort(v.begin(), v.end());
        for (int i = 0; i + 2 < v.size(); i++) {
            if (v[i+2] - v[i] <= 60) {
                return true;
            }
        }
        return false;
    }
};