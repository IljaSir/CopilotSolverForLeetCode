class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        int[] res = new int[]{0, 1};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]];
            }
        });
        for(int i = 0; i < n - 1; i++){
            pq.add(new int[]{i, n - 1});
        }
        while(k > 0){
            int[] curr = pq.poll();
            res[0] = arr[curr[0]];
            res[1] = arr[curr[1]];
            if(curr[1] - 1 > curr[0]){
                pq.add(new int[]{curr[0], curr[1] - 1});
            }
            k--;
        }
        return res;
    }
}