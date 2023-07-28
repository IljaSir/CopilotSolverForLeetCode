class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<Long>();
        long sum = 0;
        long count = 0;
        while (sum < finalSum) {
            long value = 2;
            while (sum + value > finalSum) {
                value *= 2;
            }
            sum += value;
            count++;
        }
        for (int i = 0; i < count; i++) {
            result.add((long) Math.pow(2, i));
        }
        return result;
    }
}