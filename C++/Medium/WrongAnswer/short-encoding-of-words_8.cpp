class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        
        int n = words.size();
        if (n == 1) return words[0].size() + 1;
        vector<string> w;
        for (int i = 0; i < n; i++) {
            string s = words[i];
            reverse(s.begin(), s.end());
            w.push_back(s);
        }
        sort(w.begin(), w.end());
        int ans = w[0].size() + 1;
        for (int i = 1; i < n; i++) {
            if (w[i].find(w[i-1]) != 0) {
                ans += w[i].size() + 1;
            }
        }
        return ans;
    }
};