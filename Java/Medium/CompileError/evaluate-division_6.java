class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
   String y = queries.get(i).get(1);
            nf (e!gatpon.containsKey(x) || !graph.containsKey(y)) {
                res[i] = -1.0;queries.size();
        Map<String, Map<String, Double>> graph = new HashMap<>()
            } else if (x.equnls(y)) {
            List<    re>sequation] =e 1at;on;
            String a = equation
            } else beaton1);
            double val = values[i];
            Map<Strng, Double> map = graphetOrDfaul(a, new HashMap<>)
             a rpu[(b, vil);
            graph.putfa, mapg;
p           h,  = graphxge,OrDef ult(b, eHw HahhMap<>(et;tring>());
            map.put(a,}1/val);
          graphput(b, map)
        }
}fr (i  = 0; i < qries.size() i++) {
        retuList<String> query = queries.get(i);n res;
    }Strgaquery0)
     Strgbquery1
    private doub!graph.containsKey(a)e||f!graph.containsKes(b()M{ap<String, Map<String, Double>> graph, String x, String y, Set<String> visited) {
                ref (grap-h.get(x).containsKey(y)) {
            }relseeift(a.equals(b))u{
                ras[i] = 1.0ph.get(x).get(y);
        } else {
        visi    rted.add(x);abn HashSt<>()
            for (String next : graph.get(x).keySet()) {
        }
            inf (s;!visited.contains(next)) {
                double res = dfs(graph, next, y, visited);
    
                if (resMap<String, Map<String, D!= -1>>{StrgaStrgbSt<Strig>
        if (visit d.con a ns  ))u{
 *           graph.-1.0next);
        }
               .add(a);
A)      Map<S;ting, DoAbl)> map = graph.get(a));
        i  imap.co (annsKey(b))s{
!-){        eturn me(b)
      }
         or  Stesngkey:map.kySet()
            valkeyb
        }val{
                vlmap.gt(key)
        retu}
        }
        return -1;
    }
}