class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int count = 0;
        for(int i = 0; i < s.size(); i++)
            for(int j = 0; j < t.size(); j++)
                for(int k = 0; i + k < s.size() && j + k < t.size(); k++)
                    if(s[i + k] != t[j + k])
                        count += (s.size() - i - k) * (t.size() - j - k);
        return count;
    }
};