class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int ans = 0;
        map<string, int> m;
        for (auto word: words) {
            string s = word;
            sort(s.begin(), s.end());
            for (auto c: s) {
                string t = s;
                t.erase(remove(t.begin(), t.end(), c), t.end());
                ans += m[t];
            }
            m[s]++;
        }
        return ans;
    }
};