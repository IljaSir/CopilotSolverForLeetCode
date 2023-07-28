class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        long sum = 0;
        long number = 2;
        while (number <= finalSum) {
            sum += number;
            result.add(number);
            number += 2;
        }
        if (sum < finalSum) {
            result.add(finalSum - sum);
        }
        return result;
    }
}