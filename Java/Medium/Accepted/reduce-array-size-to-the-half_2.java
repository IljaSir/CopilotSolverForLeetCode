class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int key : map.keySet()) {
            heap.offer(map.get(key));
        }
        int res = 0;
        int count = 0;
        while (count < arr.length / 2) {
            count += heap.poll();
            res++;
        }
        return res;
    }
}