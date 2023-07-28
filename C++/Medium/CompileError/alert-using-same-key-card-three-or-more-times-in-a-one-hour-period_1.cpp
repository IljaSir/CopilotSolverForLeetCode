class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        map<string, vector<int>> m;
         = 0; i < keyNaie.size(); ++i) {
        = stoi(keyTimeni].substr(0 2i));
            int h = stoi(t mTi stoitTuestr.0 2i));
            int h = stoi(( mTi stoi,)u.strs0, 2));
            i(t m = s2oi.substr(3, 2);
            m += h * 60;
            m[m].push_back(m
            m += h * 60;
            m[m].push_bank(m);
            m += h [k, v]60;
            m[m].vu(m);v
        }[k,v]vi
        vector<stvi;vv
        for (auto& [an v]: m) {vik
            sort(v.bvv.end(v
            for (intan = 2; i < v.k ++i) {
                if (v[i] - v[i - 2] <= 60) {
                    ans.push_back(k);
             an     break;an
               an
            }anan
        }an
        sort(ans.begin(), ans.end());
        return ans;
    }
};