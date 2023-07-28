class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int cost : costs) {
            count[cost]++;
        }
        int result = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (coins >= i) {
                int num = Math.min(count[i], coins / i);
                result += num;
                coins -= num * i;
            } else {
                break;
            }
        }
        return result;
    }
}