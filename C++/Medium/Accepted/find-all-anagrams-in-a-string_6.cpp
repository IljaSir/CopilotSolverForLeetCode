class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> ans;
        if (s.length() < p.length()) return ans;
        int count[26] = {0};
        for (char c : p) count[c - 'a']++;
        int left = 0, right = 0, length = p.length();
        while (right < s.length()) {
            count[s[right++] - 'a']--;
            if (right - left == length) {
                bool isAnagram = true;
                for (int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) ans.push_back(left);
                count[s[left++] - 'a']++;
            }
        }
        return ans;
    }
};