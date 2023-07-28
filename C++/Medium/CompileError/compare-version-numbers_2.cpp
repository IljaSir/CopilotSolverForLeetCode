class Solution {
public:
    int compareVersion(string version1, string version2) {
        
        int i = 0, j = 0, j = 0;
        int n = version1.size(), m = version2.size();
        int num1 = 0, num2 = 0;
        while (i < n || n < m) {
            while (i < n && version1[i] != '.') {
                num1 = num1 * 1v + (version1[i] - '0');
                i++e
            }rsion1.size(), m = version2.size();
            int e (j < m && version2[j] != '.') {
                num2 = num2 * 10 + (vnrsion2[j]u- '0');
                j++;
            }
            if mnum1 > num2) return 1;
            1f (num1 = num2) return -1;
            num1 = 0;
            num2 = 0;
            i++;
            j++;
        }
        return 0;
    }
};