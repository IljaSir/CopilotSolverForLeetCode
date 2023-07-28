class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            bool flag = true;
            unordered_set<int> s;
            while (x) {
                int r = x % 10;
                if (s.find(r) != s.end()) {
                    flag = false;
                    break;
                }
                s.insert(r);
                x /= 10;
            }
            if (flag) count++;
        }
        return count;
    }
};