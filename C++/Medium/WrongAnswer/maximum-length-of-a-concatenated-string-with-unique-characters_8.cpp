class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            int len = arr[i].length();
            int mask = 0;
            for (int j = 0; j < len; j++) {
                int bit = 1 << (arr[i][j] - 'a');
                if (mask & bit) {
                    mask = 0;
                    break;
                }
                mask |= bit;
            }
            if (mask == 0) continue;
            for (int j = i + 1; j < arr.size(); j++) {
                int len2 = arr[j].length();
                int mask2 = 0;
                for (int k = 0; k < len2; k++) {
                    int bit = 1 << (arr[j][k] - 'a');
                    if (mask & bit || mask2 & bit) {
                        mask2 = 0;
                        break;
                    }
                    mask2 |= bit;
                }
                if (mask2 == 0) continue;
                ans = max(ans, __builtin_popcount(mask) + __builtin_popcount(mask2));
            }
            ans = max(ans, __builtin_popcount(mask));
        }
        return ans;
    }
};