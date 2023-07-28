class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> res = new ArrayList<>();
        int i = 1;
        while (finalSum > 0) {
            if (finalSum >= 2 * i) {
                res.add(2L * i);
                finalSum -= 2 * i;
            } else {
                res.add(finalSum);
                finalSum = 0;
            }
            i++;
        }
        return res;
    }
}