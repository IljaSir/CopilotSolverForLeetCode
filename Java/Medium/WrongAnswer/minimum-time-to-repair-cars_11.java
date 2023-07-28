class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        Arrays.sort(ranks);
        long low = 1;
        long high = (long)1e12;
        long ans = -1;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;
            for(int rank : ranks) {
                count += (mid / (rank * rank));
                if(count >= cars)
                    break;
            }
            if(count >= cars) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}