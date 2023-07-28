class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        
        int max = 0;
        int maxIndex = -1;
        int sum = 0;
        int index = 0;
        int count = 0;
        int temp = 0;
        int wait = 0;
        while (index < customers.length || wait > 0) {
            if (index < customers.length) {
                wait += customers[index];
            }
            temp = Math.min(wait, 4);
            wait -= temp;
            sum += temp;
            count++;
            temp = sum * boardingCost - count * runningCost;
            if (temp > max) {
                max = temp;
                maxIndex = count;
            }
            index++;
        }
        return maxIndex;
    }
}