class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int len1 = s1.size();
        int len2 = s2.size();
        if (len1 > len2) return false;
        vector<int> v1(26, 0);
        vector<int> v2(26, 0);
        for (int i = 0; i < len1; ++i) {
            v1[s1[i] - 'a']++;
            v2[s2[i] - 'a']++;
        }
        for (int i = 0; i < len2 - len1; ++i) {
            if (v1 == v2) return true;
            v2[s2[i] - 'a']--;
            v2[s2[i + len1] - 'a']++;
        }
        return v1 == v2;
    }
};