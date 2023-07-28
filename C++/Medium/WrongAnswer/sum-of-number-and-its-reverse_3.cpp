class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int sum = 0;
        int temp = num;
        while (temp) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }
        return num == sum;
    }
    bool isPalindrome(int num) {
        int sum = 0;
        int temp = num;
        while (temp) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }
        return num == sum;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int n1 = firstWord.size();
        int n2 = secondWord.size();
        int n3 = targetWord.size();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < n1; i++) {
            sum1 = sum1 * 10 + firstWord[i] - 'a';
        }
        for (int i = 0; i < n2; i++) {
            sum2 = sum2 * 10 + secondWord[i] - 'a';
        }
        for (int i = 0; i < n3; i++) {
            sum3 = sum3 * 10 + targetWord[i] - 'a';
        }
        return sum1 + sum2 == sum3;
    }
    bool isSumEqual1(string firstWord, string secondWord, string targetWord) {
        int n1 = firstWord.size();
        int n2 = secondWord.size();
        int n3 = targetWord.size();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < n1; i++) {
            sum1 = sum1 * 10 + firstWord[i] - 'a';
        }
        for (int i = 0; i < n2; i++) {
            sum2 = sum2 * 10 + secondWord[i] - 'a';
        }
        for (int i = 0; i < n3; i++) {
            sum3 = sum3 * 10 + targetWord[i] - 'a';
        }
        return sum1 + sum2 == sum3;
    }
};