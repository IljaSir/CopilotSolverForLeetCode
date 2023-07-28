class Solution {
public:
    int convertTime(string current, string correct) {
        
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        int minute1 = h1 * 60 + m1;
        int minute2 = h2 * 60 + m2;
        int minute = minute2 - minute1;
        int result = 0;
        int a[] = {60, 15, 5, 1};
        for (int i = 0; i < 4; i++) {
            result += minute / a[i];
            minute = minute % a[i];
        }
        return result;
    }
    int minOperations(string current, string correct) {
        int h1 = stoi(current.substr(0, 2));
        int m1 = stoi(current.substr(3, 2));
        int h2 = stoi(correct.substr(0, 2));
        int m2 = stoi(correct.substr(3, 2));
        int minute1 = h1 * 60 + m1;
        int minute2 = h2 * 60 + m2;
        int minute = minute2 - minute1;
        int result = 0;
        int a[] = {60, 15, 5, 1};
        for (int i = 0; i < 4; i++) {
            result += minute / a[i];
            minute = minute % a[i];
        }
        return result;
    }
};