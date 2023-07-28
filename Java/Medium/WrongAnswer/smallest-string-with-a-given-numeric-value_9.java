class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] str = new char[n];
        int i = 0;
        int z = 0;
        while (k > 0) {
            if (k > 26) {
                str[i] = 'a';
                k -= 1;
            } else {
                str[i] = (char) (k + 96);
                k = 0;
            }
            i++;
        }
        z = n - i;
        while (z > 0) {
            str[i] = 'z';
            z--;
            i++;
        }
        return new String(str);
    }
}