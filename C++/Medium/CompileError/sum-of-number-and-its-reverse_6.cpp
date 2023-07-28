class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int temp = num;
        int reverse = 0;
        while(temp > 0){
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        if(num == reverse) return true;
        return false;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int first = 0;
        int second = 0;
        int target = 0;
        for(int i = 0; i < firstWord.size(); i++){
            first = first * 10 + (firstWord[i] - 'a');
        }
        for(int i = 0; i < secondWord.size(); i++){
            second = second * 10 + (secondWord[i] - 'a');
        }
        for(int i = 0; i < targetWord.size(); i++){
            target = target * 10 + (targetWord[i] - 'a');
        }
        if((first + second) == target) return true;
        return false;
    }
    bool checkPowersOfThree(int n) {
        while(n > 0){
            if(n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int first = 0;
        int second = 0;
        int target = 0;
        for(int i = 0; i < firstWord.size(); i++){
            first = first * 10 + (firstWord[i] - 'a');
        }
        for(int i = 0; i < secondWord.size(); i++){
            second = second * 10 + (secondWord[i] - 'a');
        }
        for(int i = 0; i < targetWord.size(); i++){
            target = target * 10 + (targetWord[i] - 'a');
        }
        if((first + second) == target) return true;
        return false;
    }
};