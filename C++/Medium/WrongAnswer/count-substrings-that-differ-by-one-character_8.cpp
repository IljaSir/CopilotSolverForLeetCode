class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int cnt = 0;
        for(int i = 0; i < s.size(); i++){
            for(int j = 0; j < t.size(); j++){
                int k = 0;
                while(i+k < s.size() && j+k < t.size() && s[i+k] == t[j+k]) k++;
                if(k > 0 && i+k < s.size() && j+k < t.size() && s[i+k] != t[j+k]) cnt++;
                k = 0;
                while(i+k < s.size() && j+k < t.size() && s[i+k] == t[j+k]) k++;
                if(k > 0 && i+k < s.size() && j+k < t.size() && s[i+k] != t[j+k]) cnt++;
            }
        }
        return cnt;
    }
};