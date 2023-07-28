class Solution {
public:
    long long countVowels(string word) {
        
        int n = word.size();
        long long ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (isVowel(word[i])) {
                cnt++;
            }
            ans += cnt;
        }
        return ans;
    }
};