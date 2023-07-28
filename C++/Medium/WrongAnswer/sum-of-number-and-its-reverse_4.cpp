class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int rev = 0;
        int n = num;
        while(n>0) {
            rev = rev*10 + n%10;
            n = n/10;
        }
        return num == rev;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int a=0, b=0, c=0;
        int n = firstWord.size();
        for(int i=0; i<n; i++) {
            a = a*10 + firstWord[i]-'a';
        }
        n = secondWord.size();
        for(int i=0; i<n; i++) {
            b = b*10 + secondWord[i]-'a';
        }
        n = targetWord.size();
        for(int i=0; i<n; i++) {
            c = c*10 + targetWord[i]-'a';
        }
        return a+b == c;
    }
};