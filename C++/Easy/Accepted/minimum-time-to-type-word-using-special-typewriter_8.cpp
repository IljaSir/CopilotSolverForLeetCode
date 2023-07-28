class Solution {
public:
    int minTimeToType(string word) {
        
        int n = word.size();
        int ans = n;
        char last = 'a';
        for (int i = 0; i < n; i++) {
            int dist = abs(word[i] - last);
            ans += min(dist, 26 - dist);
            last = word[i];
        }
        return ans;
    }
};