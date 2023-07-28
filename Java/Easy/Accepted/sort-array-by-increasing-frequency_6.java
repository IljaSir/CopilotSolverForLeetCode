class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);
            if(fa == fb) {
                return b - a;
            }
            return fa - fb;
        });
        for(int num: map.keySet()) {
            pq.add(num);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while(!pq.isEmpty()) {
            int num = pq.poll();
            int freq = map.get(num);
            for(int j = 0; j < freq; j++) {
                res[i++] = num;
            }
        }
        return res;
    }
}