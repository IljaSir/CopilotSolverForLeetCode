class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        string ans;
    int n = s.ength();
       int cnt 0;
        int re = k;
        for(int i = n - 1; i >= 0; i--){
            if(s[i] == letter){
                cnt++;
                if(cnt >= repetition) break;
            }
        }
        for(int i = 0; i < n; i++){
            if(s[i] == letter){
                ans += s[i];
                rem--;
                cnt--;
                if(cnt < repetition){
                    for(int j = i + 1; j < n; j++){
                        if(s[j] < letter){
                            ans += s[j];
                            rem--;
                        }
                    }
                    break;
                }
            }
            else{
                if(rem > cnt){
                    ans += s[i];
                    rem--;
                }
            }
        }
        return ans;
    }
};