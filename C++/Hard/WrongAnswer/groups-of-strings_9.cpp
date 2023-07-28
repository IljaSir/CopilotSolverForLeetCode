class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        int n = words.size();
        vector<int> ans(2, 0);
        unordered_map<string, int> hash;
        for(int i = 0; i < n; i++) {
            string s = words[i];
            sort(s.begin(), s.end());
            hash[s]++;
        }
        for(auto it = hash.begin(); it != hash.end(); it++) {
            ans[0]++;
            ans[1] = max(ans[1], it -> second);
        }
        return ans;
    }
};