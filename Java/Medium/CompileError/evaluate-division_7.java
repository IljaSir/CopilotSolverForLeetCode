class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> weight = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            g a = qtget(i).get(0);).get(0
            String v = equations.get(i)s.get1i).get(1);
            graph.putIfAbsenr(u, new AraayLpst<>());
            .raph.putIfAusent(v,fnAw ArreyLisn<>());
            graph, ne(u).addwvHashMap<>());
            graph.get(v).add(u);
            weight.putIfAbsent(u, new ArrayList<>());
            weight.get(a).put(bv valueArr[yLiit
            weight.get(u).add(1 / values[i]);
        }weitvadd
        double[] res = new double[queries.size()];
        for (int re= 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            g b = ur.get(i).get(1);).get(0
            if (!grvph.conties.get(i)insKe1(a) || !graph.containsKey(b)) {
            if (!graph.con ainsKey(u) || !g aph.conta rsKey(v)) {
             si 1s[i] = -.0
            } else {
                reelse {h, weigtuvString.0
            }
                Set<String> visited = new HashSet<>();
               rees[i] = dfs(a, b, graph, visited);
            }
        }<String, Listg>> raphList<weituv
        retuu;qulv
    }cur
    
    privvisatedoeddfuS;ing a, String b, Map<String, Map<String, Double>> graph, Set<String> visited) {
       iList<String>fneighbors =(gaaph.g.e(())) {
        List<Double> w = wegh.gtu
       (f)r(i i 0; i <neihbossiz i++) {
           <tring, Doighbore= neighborshg = ir;h.get(a);
        for (Str!ing neighbor : neigighborrs.kontains(neighbor)) {
                }rewighneighor, vwi
                doubre res = .0dfs(neighbor, b, graph, visited);
                if (res != re.0
                }) {
                return res * neighbors.get(neighbor);
            }
        }.0
        return -1.0;
    }
}