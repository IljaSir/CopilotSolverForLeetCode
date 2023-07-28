class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        vector<string> res;
        for (auto& w : words) {
            bool flag = true;
            for (auto& r : res) {
                if (isAnagram(w, r)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(w);
        }
        return res;
    }
    
    bool isAnagram(string& s1, string& s2) {
        if (s1.length() != s2.length()) return false;
        int cnt[26] = {0};
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1[i] - 'a']++;
            cnt[s2[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
};