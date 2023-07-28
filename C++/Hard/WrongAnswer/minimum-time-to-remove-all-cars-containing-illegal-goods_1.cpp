class Solution {
public:
    int minimumTime(string s) {
        
        int n = s.size();
        int left = 0, right = n - 1;
        while (left < n && s[left] == '0') left++;
        while (right >= 0 && s[right] == '0') right--;
        if (left > right) return 0;
        int res = 2;
        for (int i = left + 1; i <= right; i++) {
            if (s[i] == '1') res += 2;
            else res++;
        }
        return res;
    }
};