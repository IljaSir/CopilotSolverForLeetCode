class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        List<Integer> result = new ArrayList();
        int[] count = new int[k];
        TreeSet<Integer> available = new TreeSet();
        for(int i=0;i<k;i++)
            available.add(i);
        TreeMap<Integer, TreeSet<Integer>> busy = new TreeMap();
        for(int i=0;i<arrival.length;i++){
            int start = arrival[i];
            int end = start + load[i];
            while(!busy.isEmpty() && busy.firstKey() < start){
                int server = busy.firstEntry().getValue().pollFirst();
                if(busy.firstEntry().getValue().isEmpty())
                    busy.pollFirstEntry();
                available.add(server);
            }
            if(available.isEmpty())
                continue;
            Integer server = available.ceiling(i%k);
            if(server == null)
                server = available.first();
            available.remove(server);
            count[server]++;
            if(!busy.containsKey(end))
                busy.put(end, new TreeSet());
            busy.get(end).add(server);
        }
        int max = 0;
        for(int i=0;i<k;i++)
            max = Math.max(max, count[i]);
        for(int i=0;i<k;i++)
            if(count[i] == max)
                result.add(i);

        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                available.add(pq.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            int index = arrival[i] % k;
            Integer next = available.ceiling(index);
            if (next == null) {
                next = available.ceiling(0);
            }
            if (next != null) {
                pq.offer(new int[] {arrival[i] + load[i], next});
                available.remove(next);
            }
        }
        int max = 0;
        int[] count = new int[k];
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            count[item[1]]++;
            max = Math.max(max, count[item[1]]);
        }
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}