class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.size();
        if(n < k) return false;
        int max = (1 << k) - 1;
        int mask = 0;
        int i = 0;
        for(; i < k; ++i) {
            mask = (mask << 1) + (s[i] - '0');
        }
        //cout << "mask:" << mask << endl;
        vector<bool> v(max + 1, false);
        v[mask] = true;
        int cnt = 1;
        for(; i < n; ++i) {
            mask = ((mask << 1) + (s[i] - '0')) & max;
            if(!v[mask]) {
                v[mask] = true;
                ++cnt;
            }
        }
        return cnt == max + 1;
    }
};