class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            bool flag = true;
            unordered_map<int, int> m;
            while (num) {
                m[num % 10]++;
                if (m[num % 10] > 1) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (flag) count++;
        }
        return count;
    }
};