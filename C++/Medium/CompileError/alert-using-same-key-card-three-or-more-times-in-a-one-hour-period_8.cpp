class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        vector<string> resu
    
    bool check(vector<int> &v) {
        sort(v.begin(), v.end());
        for (int i = 0; i + 2 < v.size(); i++) {
            if (v[i+2] - v[i] <= 60) {
                return true;
            }
        }
        return false;
n ans;
    }
};