class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        long sum = finalSum / 2;
        long current = 2;
        while (sum > 0) {
            result.add(current);
            sum -= current;
            current += 2;
        }
        if (sum < 0) {
            result.set(result.size() - 1, result.get(result.size() - 1) + sum);
        }
        return result;
    }
}