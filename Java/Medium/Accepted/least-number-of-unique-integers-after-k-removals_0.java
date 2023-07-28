class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        while (k > 0) {
            int key = pq.poll();
            int value = map.get(key);
            if (value <= k) {
                k -= value;
                map.remove(key);
            } else {
                map.put(key, value - k);
                k = 0;
            }
        }
        return map.size();
    }
}