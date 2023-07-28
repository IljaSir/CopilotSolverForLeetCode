class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
    public int maximumScore(int[] nums, int k) {
        long max = maxKelements(nums, k);
        int l = k - 1;
        int r = k + 1;
        while(l >= 0 || r < nums.length) {
            if(l >= 0 && r < nums.length) {
                if(nums[l] > nums[r]) {
                    max = Math.max(max, maxKelements(nums, l));
                    l--;
                } else {
                    max = Math.max(max, maxKelements(nums, r));
                    r++;
                }
            } else if(l >= 0) {
                max = Math.max(max, maxKelements(nums, l));
                l--;
            } else {
                max = Math.max(max, maxKelements(nums, r));
                r++;
            }
        }
        return (int) max;
    }
}