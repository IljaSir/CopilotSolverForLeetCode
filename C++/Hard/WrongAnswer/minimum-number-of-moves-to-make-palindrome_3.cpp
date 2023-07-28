class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            if (s[i] != s[j]) {
                int k = j - 1;
                while (k > i && s[i] != s[k]) {
                    k--;
                }
                if (k == i) {
                    count += 1;
                } else {
                    count += j - k;
                    while (k < j) {
                        swap(s[k], s[k + 1]);
                        k++;
                    }
                }
            }
        }
        return count;
    }
};