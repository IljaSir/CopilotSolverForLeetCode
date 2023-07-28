class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        long sum = 0;
        long count = 0;
        while (sum < finalSum) {
            sum += 2;
            count++;
        }
        if (sum == finalSum) {
            for (long i = 0; i < count; i++) {
                result.add(2L);
            }
        } else {
            for (long i = 0; i < count - 1; i++) {
                result.add(2L);
            }
            result.add(finalSum - sum + 2);
        }
        return result;
    }
}