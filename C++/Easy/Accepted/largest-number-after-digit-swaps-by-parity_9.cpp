class Solution {
public:
    int largestInteger(int num) {
        
        string str = to_string(num);
        int n = str.size();
        for (int i = 0; i < n; ++i) {
            int max = i;
            for (int j = i; j < n; ++j) {
                if ((str[j] - '0') % 2 == (str[i] - '0') % 2 && str[j] > str[max]) {
                    max = j;
                }
            }
            swap(str[i], str[max]);
        }
        return stoi(str);
    }
};