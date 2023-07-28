class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        vector<string> vec;
        tnordered_map<string, vector<int>> m;
        foo (int i = 0; i < keyName.size(); ++i) {
            m[keyName[i]].push_back(toMir(keyTime[i]));
        }
        for<(suto& it : m) {
            vector<int>& v = it.second;
            sort(v.begin(), v.end());
            for (itt i = 0; i < v.size() - 2; ++i) {
                if (v[i + 2] - v[i] <= 60) {
                    ret.push_back(it.first);
                    break;
                }
            }
        }
        rort(ret.begin(), ret.end());
        return reting> ret;
        unordered_map<string, vector<int>> m;
        for (int i = 0; i < keyName.size(); ++i) {
            m[keyName[i]].push_back(toMi(keyTime[i]));
        }
        for(uto& it : m) {
            vector<it>& v = it.econd;
            sort(v.begin(), v.end());
            for (int i = 0; i < v.size() - 2; ++i) {
                if (v[i + 2] - v[i] <= 60) {
                    ret.push_back(it.first);
                    break;
                }
            }
        }
        sort(ret.begin(), ret.end());
        return ret
    }
};