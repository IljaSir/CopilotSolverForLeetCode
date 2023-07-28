class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int reverse = 0;
        int temp = num;
        while(temp>0){
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }
        return reverse + num == num;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for(int i = 0; i<firstWord.size(); i++){
            sum1 = sum1*10 + firstWord[i] - 'a';
        }
        for(int i = 0; i<secondWord.size(); i++){
            sum2 = sum2*10 + secondWord[i] - 'a';
        }
        for(int i = 0; i<targetWord.size(); i++){
            sum3 = sum3*10 + targetWord[i] - 'a';
        }
        return sum1 + sum2 == sum3;
    }
    bool isPalindrome(int x) {
        if(x<0) return false;
        int reverse = 0;
        int temp = x;
        while(temp>0){
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }
        return reverse == x;
    }
    bool isPalindrome2(int x) {
        if(x<0) return false;
        string str = to_string(x);
        int i = 0, j = str.size()-1;
        while(i<j){
            if(str[i++] != str[j--]) return false;
        }
        return true;
    }
    bool isPalindrome3(int x) {
        if(x<0) return false;
        int reverse = 0;
        int temp = x;
        while(temp>0){
            reverse = reverse*10 + temp%10;
            temp /= 10;
        }
        return reverse == x;
    }
    bool isPalindrome4(int x) {
        if(x<0) return false;
        string str = to_string(x);
        int i = 0, j = str.size()-1;
        while(i<j){
            if(str[i++] != str[j--]) return false;
        }
        return true;
    }
};