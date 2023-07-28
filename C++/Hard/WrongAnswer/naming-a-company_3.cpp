class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        
        int len = ideas.size();
        long long ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                string s1 = ideas[i], s2 = ideas[j];
                swap(s1[0], s2[0]);
                if (find(ideas.begin(), ideas.end(), s1) == ideas.end() &&
                    find(ideas.begin(), ideas.end(), s2) == ideas.end()) {
                    ans++;
                }
            }
        }
        return ans;
    }
};