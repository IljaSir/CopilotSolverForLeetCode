class Solution {
public:
    int maxVowels(string s, int k) {
        
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < s.size()) {
            if (isVowel(s[j])) {
                count++;
            }
            if (j - i + 1 > k) {
                if (isVowel(s[i])) {
                    count--;
                }
                i++;
            }
            if (j - i + 1 == k) {
                if (count > max) {
                    max = count;
                }
            }
            j++;
        }
        return max;
    }
};