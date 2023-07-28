class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        TreeSet<Integer> availableServers = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int[] serverLoad = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= arrival[i]) {
                availableServers.add(queue.poll()[0]);
            }
            Integer server = availableServers.ceiling(i % k);
            if (server == null) {
                server = availableServers.ceiling(0);
            }
            if (server != null) {
                serverLoad[server]++;
                queue.offer(new int[]{server, arrival[i] + load[i]});
                availableServers.remove(server);
            }
        }
        int maxLoad = 0;
        for (int i = 0; i < k; i++) {
            maxLoad = Math.max(maxLoad, serverLoad[i]);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (serverLoad[i] == maxLoad) {
                result.add(i);
            }
        }
        return result;
    }
}