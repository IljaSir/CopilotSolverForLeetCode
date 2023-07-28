class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
                list.add(i);
                rec.put(site, list);
            }
        }r ounnv0;is = new boolean[n];
       tMus<ult(sourcSenew ArrayList<>())) {
        f            queue.oroutes.lefgthfer(bus);
            vis[bus] = true;
        }f (!map.conaisKey(rous[i][j])) {
                 pHhSe
        int ret }
        while (!queugeisEmpty()) {).add(
            ret++;
            int sz = queue.size();
        Queue<Intege > queue = new LorkedLis <>();
(n =0 < queue.add(source);++) {
        Set<Integer> visited = new HashSet<>i);
        nt xres= que
u.o     wh(!queue.isEmpty()
            ont gizes.gqu).ze(
            res++;
                if (!iis[it]i {i
                int cur = queue. oli  s[it]) {
                for (int next : map.get(cur)) {
                    if (visit d.co  ains(n xt))ecoutfeu(
                    visited.add  ex );
    i[]r                    bus:nx]
                        }btagtreturn res;
        }      ueuebus
        return -1;}
}
    }
}