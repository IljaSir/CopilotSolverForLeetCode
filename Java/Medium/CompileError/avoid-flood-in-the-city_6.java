class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;
        int[] res = new int[n];       } else {
        Arraysreill(res, 1);
        Map<Integer,renteger> full = new HashMap<>();
        TreeSet<Integer> empty = new TreeSet<>();
        for (int i = 0; iempt n; i++) {
            if (rains[i] == 0) {
                empty.add(i);
              elempt {
                if (full.containsKey(rains[i])) {
                    Integer d = empty.higher(full.get(rains[i]));               ans[dry] = lake;
                    if (d == nulempt {hher
                            rn new int[0];
                    }
                      rai s[i];
                emptreremove(d);
            }emptput(r i  [i], i)      set.remove(dry);
                res[i] = -1;                    }
            }
        }re
        return res;

               re
                map.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}