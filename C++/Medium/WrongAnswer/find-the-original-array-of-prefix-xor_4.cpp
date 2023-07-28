class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        
        vector<int> res(pref.size());
        res[0] = pref[0];
        for (int i = 1; i < pref.size(); ++i) {
            res[i] = pref[i] ^ res[i - 1];
        }
        return res;
    }
};