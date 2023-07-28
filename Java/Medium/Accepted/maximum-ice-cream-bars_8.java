class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] counts = new int[100001];
        for (int cost : costs) {
            counts[cost]++;
        }
        int result = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            if (i <= coins) {
                int count = Math.min(counts[i], coins / i);
                result += count;
                coins -= count * i;
            } else {
                break;
            }
        }
        return result;
    }
}