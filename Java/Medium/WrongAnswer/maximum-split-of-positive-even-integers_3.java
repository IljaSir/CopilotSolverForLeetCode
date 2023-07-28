class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        if (finalSum <= 2) {
            return result;
        }
        long sum = 0;
        long num = 2;
        while (sum < finalSum) {
            sum += num;
            result.add(num);
            num += 2;
        }
        if (sum > finalSum) {
            result.remove(result.size() - 1);
            result.add(finalSum - (sum - num));
        }
        return result;
    }
}