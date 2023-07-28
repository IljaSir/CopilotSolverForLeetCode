class Solution {
public:
    string getHappyString(int n, int k) {
        
        int count = 0;
        string str;
        for (int i = 0; i < n; i++) {
            str += 'a';
        }
        while (count < k) {
            count++;
            for (int i = n - 1; i >= 0; i--) {
                if (str[i] != 'c') {
                    str[i]++;
                    break;
                } else {
                    str[i] = 'a';
                }
            }
            if (count == k) {
                for (int i = 0; i < n - 1; i++) {
                    if (str[i] == str[i + 1]) {
                        count--;
                        break;
                    }
                }
            }
        }
        return count == k ? str : "";
    }
};