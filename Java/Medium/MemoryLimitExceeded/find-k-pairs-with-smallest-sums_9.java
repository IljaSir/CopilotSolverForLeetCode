class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            List<Integer> list = new ArrayList<Integer>();
            list.add(pair[0]);
            list.add(pair[1]);
            result.add(list);
            k--;
        }
        return result;
    }
}