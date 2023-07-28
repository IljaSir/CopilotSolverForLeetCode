class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] count = new int[10];
        int num = n;
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        int nextNum = n + 1;
        while (nextNum > 0) {
            int[] nextCount = new int[10];
            int temp = nextNum;
            while (temp > 0) {
                nextCount[temp % 10]++;
                temp /= 10;
            }
            boolean balanced = true;
            for (int i = 0; i < 10; i++) {
                if (count[i] != nextCount[i]) {
                    balanced = false;
                    break;
                }
            }
            if (balanced) {
                return nextNum;
            }
            nextNum++;
        }
        return nextNum;
    }
}