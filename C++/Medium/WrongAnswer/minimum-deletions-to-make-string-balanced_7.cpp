class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.length();
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == 'a'){
                countA++;
            }else{
                countB++;
            }
        }
        int ans = min(countA, countB);
        int tempA = 0;
        int tempB = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == 'a'){
                tempA++;
                countA--;
            }else{
                tempB++;
                countB--;
            }
            ans = min(ans, tempB + countA);
            ans = min(ans, tempA + countB);
        }
        return ans;
    }
};