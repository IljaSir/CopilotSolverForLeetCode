class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        int n = word.length();
        vector<int> ans(n, 0);
        int num = 0;
        for(int i = 0; i < n; i++){
            num = (num * 10 + (word[i] - '0')) % m;
            if(num == 0) ans[i] = 1;
        }
        return ans;
    }
};