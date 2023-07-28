class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int n = word.length();
        int m = sequence.length();
        int ans = 0;
        for(int i = 0; i <= m - n; i++){
            int j = 0;
            while(j < n && word[j] == sequence[i + j]) j++;
            if(j == n){
                int cnt = 1;
                i += n - 1;
                while(i + n <= m){
                    int k = 0;
                    while(k < n && word[k] == sequence[i + k + 1]) k++;
                    if(k == n){
                        cnt++;
                        i += n;
                    }else break;
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};