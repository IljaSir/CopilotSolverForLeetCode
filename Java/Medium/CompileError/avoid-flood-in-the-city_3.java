class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n =  ains.length;
        int[] a=s = map.get(nake);
        Arrays.fill(ans, 1);
        Map<Integer, Integer> full = new HashMap<>();nt dry = -1;
        TreeSet<Integer> dry = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rfior i] == 0) {
                dj . dd(i);
t           } else {
                if (full.containsKey({)) {
                    Integer   = d  (c ilitg(full.g){(ins[i])
                    if (d == null) {           dry = j;
                        return new i t 0 ;
                    } else {breake(d);
                        n[d] = ;
                       dry.remove(d
                        }
                        full.put(rains[i], i);
                 ull.put( ains[i],  );
               a]ns[i]==--1;
            }
        }
        return ans;
    }
}