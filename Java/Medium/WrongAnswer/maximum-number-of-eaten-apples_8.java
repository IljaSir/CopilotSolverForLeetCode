class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int n = apples.length;
        int[] eat = new int[n];
        int[] rot = new int[n];
        for (int i = 0; i < n; i++) {
            eat[i] = apples[i];
            rot[i] = i + days[i] - 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (eat[i] > 0) {
                int j = i;
                while (j < n && eat[j] == 0) {
                    j++;
                }
                if (j < n) {
                    int eatCnt = Math.min(eat[i], eat[j]);
                    eat[i] -= eatCnt;
                    eat[j] -= eatCnt;
                    res += eatCnt;
                } else {
                    res += eat[i];
                    eat[i] = 0;
                }
            }
        }
        return res;
    }
}