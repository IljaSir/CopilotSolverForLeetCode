class Solution {
    public int countLargestGroup(int n) {
        
        int[] map = new int[37];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            map[sum]++;
            max = Math.max(max, map[sum]);
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == max) {
                count++;
            }
        }
        return count;
    }
}