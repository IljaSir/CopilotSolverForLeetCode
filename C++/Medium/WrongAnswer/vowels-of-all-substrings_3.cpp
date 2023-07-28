class Solution {
public:
    long long countVowels(string word) {
        
        long long sum = 0;
        int count = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                count++;
            }
        }
        for (int i = 0; i < word.size(); i++) {
            sum += count;
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                count--;
            }
        }
        return sum;
    }
};