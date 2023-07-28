class Solution {
public:
    int compareVersion(string version1, string version2) {
        
        int i = 0;
        int j = 0;
        while (i < version1.size() || j < version2.si
        while (i < n || j < m) {
            while (i < n && version1[i] != '.') {
                num1 = num1 * 10 + (version1[i] - '0');
                i++;
            }
            while (j < m && version2[j] != '.') {
                num2 = num2 * 10 + (version2[j] - '0');
                j++;
            }
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            num1 = 0;
            num2 = 0;
                return 1;
            }
            ++i;
            ++j;
        }
        return 0;
    }
};