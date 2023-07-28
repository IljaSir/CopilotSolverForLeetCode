class Solution {
public:
    int minSwaps(string s) {
        
        int cnt = 0;
        for (auto c : s) {
            if (c == '[') cnt++;
            else cnt--;
        }
        if (cnt != 0) return -1;
        int ans = 0;
        cnt = 0;
        for (auto c : s) {
            if (c == '[') cnt++;
            else cnt--;
            if (cnt < 0) ans++;
        }
        return ans / 2;
    }
};