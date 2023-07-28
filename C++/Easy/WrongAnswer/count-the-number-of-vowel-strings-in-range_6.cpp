class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (char ch : words[i]) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    cnt++;
                }
            }
            if (cnt == words[i].length()) {
                ans++;
            }
        }
        return ans;
    }
};