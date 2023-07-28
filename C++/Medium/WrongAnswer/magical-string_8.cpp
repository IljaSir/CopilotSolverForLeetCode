class Solution {
public:
    int magicalString(int n) {
        
        if (n == 0) return 0;
        if (n <= 3) return 1;
        int count = 1;
        int i = 2;
        int j = 3;
        int flag = 1;
        int num = 2;
        vector<int> magic(n + 1, 0);
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;
        while (j < n) {
            magic[j++] = num;
            if (magic[i] == 2) {
                magic[j++] = num;
            }
            if (num == 1 && magic[i] == 2) {
                count++;
            }
            i++;
            if (i == j) {
                num = 3 - num;
            }
        }
        return count;
    }
};