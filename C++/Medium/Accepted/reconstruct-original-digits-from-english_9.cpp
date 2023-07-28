class Solution {
public:
    string originalDigits(string s) {
        
        // 0, 2, 4, 6, 8
        // 1, 3, 5, 7
        // 9
        int cnt[10] = {0};
        for (char c : s) {
            switch (c) {
                case 'z': cnt[0]++; break;
                case 'w': cnt[2]++; break;
                case 'u': cnt[4]++; break;
                case 'x': cnt[6]++; break;
                case 'g': cnt[8]++; break;
                case 'o': cnt[1]++; break;
                case 'h': cnt[3]++; break;
                case 'f': cnt[5]++; break;
                case 's': cnt[7]++; break;
                case 'i': cnt[9]++; break;
            }
        }
        
        cnt[1] -= cnt[0] + cnt[2] + cnt[4];
        cnt[3] -= cnt[8];
        cnt[5] -= cnt[4];
        cnt[7] -= cnt[6];
        cnt[9] -= cnt[5] + cnt[6] + cnt[8];
        
        string ans;
        for (int i = 0; i < 10; i++) {
            ans.append(cnt[i], '0' + i);
        }
        return ans;
    }
};