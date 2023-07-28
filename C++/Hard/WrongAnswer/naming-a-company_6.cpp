class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long n = ideas.size();
        long long res = 0;
        unordered_set<string> us;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                string s = ideas[i];
                s[0] = ideas[j][0];
                if (us.find(s) == us.end()) {
                    us.insert(s);
                    res++;
                }
                s = ideas[j];
                s[0] = ideas[i][0];
                if (us.find(s) == us.end()) {
                    us.insert(s);
                    res++;
                }
            }
        }
        return res;
    }
};