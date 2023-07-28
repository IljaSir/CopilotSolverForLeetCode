class Solution {
    public int numWays(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                count++;
        if (count % 3 != 0)
            return 0;
        if (count == 0) {
            long n = s.length() - 1;
            return (int) ((n * (n - 1) / 2) % 1000000007);
        }
        int k = count / 3;
        int i = 0;
        int j = s.length() - 1;
        int c1 = 0;
        int c2 = 0;
        while (k > 0) {
            if (s.charAt(i) == '1')
                k--;
            i++;
            c1++;
        }
        k = count / 3;
        while (k > 0) {
            if (s.charAt(j) == '1')
                k--;
            j--;
            c2++;
        }
        return (int) ((long) c1 * c2 % 1000000007);
    }
}