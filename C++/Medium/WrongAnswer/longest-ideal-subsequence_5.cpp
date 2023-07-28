class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.length();
        vector<int> v(26, -1);
        int l = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            v[s[i] - 'a'] = i;
            while(l < i){
                int j = s[l] - 'a';
                if(v[j] > i){
                    break;
                }
                l++;
            }
            if(i - l + 1 <= k){
                ans = max(ans, i - l + 1);
            }
        }
        return ans;
    }
};