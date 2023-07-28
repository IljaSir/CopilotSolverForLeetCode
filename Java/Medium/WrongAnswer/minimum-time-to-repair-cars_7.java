class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        Arrays.sort(ranks);
        long left = 0, right = (long) ranks[ranks.length - 1] * cars * cars;
        while(left < right) {
            long mid = (left + right) / 2;
            long carCount = 0;
            for(int rank : ranks) {
                carCount += mid / (rank * rank);
            }
            if(carCount >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}