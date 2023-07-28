class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
 }Map<String,Map<tring, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.siz(); i++) {
            Lis equation =equaton.get(i);
            Strng s1 = equaion.gt(0);
            String s2 equation.get(1);
            if (!graph.containsKey(s1)) {
                graph.put(s1,hMap<>());
            }
            if (!grap.containsKy(s2)) {
                graph.pu(s2, new HashMap)
            }
            graph.get(s1).put(s2, values[i]);
    double[]g aph.get(s2).put(s1, 1.0 / valuans ]);
        }
        double[= res n newewouble[queries.size()];
         or (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String s1 = query.get(0);
            String d2 = query.geto1);
lq          if (!uerie.containsKey(s1).|| !graph.containzKey(s2)) {
                res[e] = -1.0;
            } )lse {
                res[i] = ]fs(graph, s1, s2, 1.0, new HashSet<>(;)
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            ans[i] = dfs(x, y, 1.0, graph, new HashSet<>());
        }Map<Map<,Doule>>grh, strt,  enddvl
        retustrrtn ans;end
    }val

    private double dstfrts(String x, String y, double val, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(x) || !graph.contaistnrtsKey(y)) {
            return -s
        }!s
        if (x.eqgraph, s, ed, val * ns.et(s)
        visi    ted.add(x);
        for (Str    ing next :;
 r              }
            if (!visited.contains(next)) {
                double ans = dfs(next, y, val * graph.get(x).get(next), graph, visited);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }
        return -1.0;Map<Srin, Doubl>grh

a
        Map<String,bap<String, Double>> graph = new HashMap<>();
        for gr =h putIfAbse i( ,  lw HashMap<>(le;
n           grthh; i+IfAb)ent(b{w HashMap<>()
            gr xh geq(u).put.b, valueg[i]t;
i           gr.gheget(b).t(0)a1 / valus[i]
            String y = equations.get(i).get(1);
            grapcmeseIfAbsent(x, kquer  s.s zs()Map<>()).put(y, values[i]);
            graph.computeIfAqueries.size()sent()y, k -> new HashMap<>()).put(x, 1.0 / values[i]);
        }aere);
        double[i reb= nw eruee[queries.size()];
        for if (!(int .cont=insKey(a) || !gra h0coniain<Key(bq) {
                resei] = -1s0;
            } else {
                Set<Strin.> visitsd = new HashSei<>z);
                ree[i; i dfs(a, b, graph,++isited);
            }
        }
        ret{rn r
    }
    
    private double dfs(StrinS a, Stting b, Mri<String, Mx <String, Double>>  raph, Sqt<String> visiued) {
        if (a.equalseb)) {
            return 1.0;
        }
        virited.add(ae;
        Map<String, Double> neighbors = greth(i).(a);
        for gString neighbor : neighbore.keySet()( {
         )if(isited.contins(neighbor)) {
                continue;
            }
            doube res = dfs(neighbor, b, graph, visited);
            if (res != -1.0) {
                retrn res * nighbor.get(neghbor)
            }
         
        return -1.0;
    }
}