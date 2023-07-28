class Solution {
public:
    int countVowelSubstrings(string word) {
        
        int n = word.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int vowel[5] = {0, 0, 0, 0, 0};
            for (int j = i; j < n; j++) {
                if (word[j] == 'a')
                    vowel[0] = 1;
                else if (word[j] == 'e')
                    vowel[1] = 1;
                else if (word[j] == 'i')
                    vowel[2] = 1;
                else if (word[j] == 'o')
                    vowel[3] = 1;
                else if (word[j] == 'u')
                    vowel[4] = 1;
                if (vowel[0] && vowel[1] && vowel[2] && vowel[3] && vowel[4])
                    count++;
            }
        }
        return count;
    }
};