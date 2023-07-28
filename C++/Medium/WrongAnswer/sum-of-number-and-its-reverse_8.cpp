class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int rev = 0;
        int n = num;
        while(n){
            rev = rev*10 + n%10;
            n /= 10;
        }
        return rev + num == num;
    }
    
    bool isPalindrome(int num){
        int rev = 0;
        int n = num;
        while(n){
            rev = rev*10 + n%10;
            n /= 10;
        }
        return rev == num;
    }
    
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int f = 0, s = 0, t = 0;
        for(char c : firstWord){
            f = f*10 + (c - 'a');
        }
        for(char c : secondWord){
            s = s*10 + (c - 'a');
        }
        for(char c : targetWord){
            t = t*10 + (c - 'a');
        }
        return f + s == t;
    }
};