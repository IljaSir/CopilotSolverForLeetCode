class Solution {
public:
    int minSwaps(string s) {
        
        int count = 0;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (s[i] == '[') {
                count++;
            } else {
                count--;
            }
        }
        if (count != 0) {
            return -1;
        }
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '[') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        return ans / 2;
    }
};