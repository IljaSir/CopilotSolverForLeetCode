class Solution {
public:
    int maximumSwap(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s[i] < s[max]) {
                for (int j = n - 1; j > i; j--) {
                    if (s[j] >= s[max]) {
                        max = j;
                    }
                }
                swap(s[i], s[max]);
                return stoi(s);
            }
            else if (s[i] > s[max]) {
                max = i;
            }
        }
        return num;
    }
};