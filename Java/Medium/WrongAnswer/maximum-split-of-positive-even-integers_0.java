class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        long sum = 0;
        long num = 1;
        while (sum < finalSum) {
            sum += num;
            result.add(num);
            num += 2;
        }
        if (sum > finalSum) {
            result.set(result.size() - 1, result.get(result.size() - 1) - (sum - finalSum));
        }
        return result;
    }
}