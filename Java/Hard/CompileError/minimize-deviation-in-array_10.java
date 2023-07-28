class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num: nums){
            if(num % 2 == 1){
                num *= 2;
            }
            pq.offer(-num);
        }
        int res = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int cur = -pq.poll();
            res = Math.min(res, cur - pq.peek());
            if(cur % 2 == 1){
                break;
            }
            pq.offer(-cur/2);
        }
        return re.offer(num);
            max = Math.max(max, num);
        }
        int result = Integer.MAX_VALUE;
        while (true) {
            int num = queue.poll();
            result = Math.min(result, max - num);
            if (num % 2 == 1) {
                break;
            }
            num /= 2;
            queue.offer(num);
            max = Math.max(max, num);
        }
        return result;
    }
}