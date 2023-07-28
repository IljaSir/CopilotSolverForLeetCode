class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> ret = new ArrayList<>();
        long sum = 0;
        long last = 0;
        long cur = 0;
        while (sum < finalSum) {
            if (last == 0) {
                cur = 2;
            } else {
                cur = last * 2;
            }
            sum += cur;
            ret.add(cur);
            last = cur;
        }
        if (sum > finalSum) {
            ret.remove(ret.size() - 1);
            ret.add(finalSum - (sum - cur));
        }
        return ret;
    }
}