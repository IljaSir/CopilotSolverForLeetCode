class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        int[] cnt = new int[100001];
        for(int i : arr) {
            cnt[i]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : cnt) {
            if (i > 0) {
                pq.add(i);
            }
        }
        int sum = 0;
        int res = 0;
        while(sum < n / 2) {
            sum += pq.poll();
            res++;
        }
        return res;
    }
}