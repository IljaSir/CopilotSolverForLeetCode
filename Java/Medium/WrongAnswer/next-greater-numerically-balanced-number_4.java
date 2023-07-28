class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] count = new int[10];
        int x = n;
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            while (count[i] > 0) {
                res = res * 10 + i;
                count[i]--;
            }
        }
        return res;
    }
    public int nextGreaterElement(int n) {
        int[] count = new int[10];
        int x = n;
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                count[i]--;
                for (int j = i + 1; j < 10; j++) {
                    if (count[j] > 0) {
                        count[j]--;
                        int res = nextBeautifulNumber(n);
                        if (res > n) {
                            return res;
                        }
                        count[j]++;
                    }
                }
                count[i]++;
            }
        }
        return -1;
    }
}