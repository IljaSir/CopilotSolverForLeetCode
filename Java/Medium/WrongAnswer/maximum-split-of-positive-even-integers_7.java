class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        int count = 0;
        long sum = 0;
        while (sum < finalSum) {
            long num = (finalSum - sum) / 2;
            if (num % 2 == 1) {
                num--;
            }
            if (num == 0) {
                num = 2;
            }
            result.add(num);
            sum += num;
            count++;
        }
        return result;
    }
}