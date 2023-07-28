class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] count = new int[10];
        int num = n + 1;
        while (true) {
            int temp = num;
            while (temp > 0) {
                count[temp % 10]++;
                temp /= 10;
            }
            boolean flag = true;
            for (int i = 0; i < 10; i++) {
                if (count[i] != 0 && count[i] != i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return num;
            }
            Arrays.fill(count, 0);
            num++;
        }
    }
}