class Solution {
public:
    bool sumOfNumberAndReverse(int num) {
        
        int temp = num;
        int rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev + num == num;
    }
    bool sumOfNumberAndReverseUsingString(int num) {
        string str = to_string(num);
        string rev = str;
        reverse(rev.begin(), rev.end());
        return stoi(str) + stoi(rev) == num;
    }
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int sum = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            sum = sum * 10 + firstWord[i] - 'a';
        }
        for (int i = 0; i < secondWord.length(); i++) {
            sum = sum * 10 + secondWord[i] - 'a';
        }
        int target = 0;
        for (int i = 0; i < targetWord.length(); i++) {
            target = target * 10 + targetWord[i] - 'a';
        }
        return sum == target;
    }
    bool isSumEqualUsingString(string firstWord, string secondWord, string targetWord) {
        string first = "";
        string second = "";
        string target = "";
        for (int i = 0; i < firstWord.length(); i++) {
            first += to_string(firstWord[i] - 'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            second += to_string(secondWord[i] - 'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            target += to_string(targetWord[i] - 'a');
        }
        return stoi(first) + stoi(second) == stoi(target);
    }
    bool isSumEqualUsingStringAndSumOfNumberAndReverse(int firstWord, int secondWord, int targetWord) {
        string first = "";
        string second = "";
        string target = "";
        for (int i = 0; i < firstWord.length(); i++) {
            first += to_string(firstWord[i] - 'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            second += to_string(second
    }
};