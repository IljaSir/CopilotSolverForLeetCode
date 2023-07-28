class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        vector<bool> ans;
        for(auto q: queries){
            int l = q[0], r = q[1], k = q[2];
            string sub = s.substr(l, r-l+1);
            int n = sub.length();
            int cnt = 0;
            unordered_map<char, int> m;
            for(int i = 0; i < n; i++){
                m[sub[i]]++;
            }
            for(auto it = m.begin(); it != m.end(); it++){
                if(it->second%2 != 0) cnt++;
            }
            if(cnt/2 <= k) ans.push_back(true);
            else ans.push_back(false);
        }
        return ans;
    }
};