class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        long long n = ideas.size();
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                string s1 = ideas[i];
                string s2 = ideas[j];
                swap(s1[0], s2[0]);
                if (s1 != ideas[i] && s2 != ideas[j]) ans++;
            }
        }
        return ans;
    }
};