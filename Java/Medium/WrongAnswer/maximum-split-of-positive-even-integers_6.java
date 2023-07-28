class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<Long>();
        long sum = 0;
        long num = 1;
        while (finalSum > 0) {
            if (finalSum >= num) {
                sum += num;
                result.add(num);
                finalSum -= num;
            } else {
                sum += finalSum;
                result.add(finalSum);
                finalSum = 0;
            }
            num = sum + 1;
        }
        return result;
    }
}