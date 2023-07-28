class Solution {
public:
    string sortString(string s) {
        
        int len = s.length();
        int count[26] = {0};
        for(int i = 0; i < len; i++) {
            count[s[i] - 'a']++;
        }
        string ans = "";
        while(ans.length() < len) {
            for(int i = 0; i < 26; i++) {
                if(count[i] > 0) {
                    ans += 
                }ou
            }
        }
            for(int i = 25; i >= 0; i--) {
                if(count[i] > 0) {
                    ans += (i + 'a');
                    count[i]--;
                }
            return result;
}
        
    }
};