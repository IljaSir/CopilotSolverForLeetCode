class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0) pq.add(new int[]{a, 0});
        if (b > 0) pq.add(new int[]{b, 1});
        if (c > 0) pq.add(new int[]{c, 2});
        while (pq.size() > 0) {
            int[] x = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == (char)('a' + x[1]) && sb.charAt(sb.length() - 2) == (char)('a' + x[1])) {
                if (pq.size() == 0) break;
                int[] y = pq.poll();
                sb.append((char)('a' + y[1]));
                if (--y[0] > 0) pq.add(y);
                pq.add(x);
              else {           c--;
                sb.append((char)('a' + x[1]));           }
                if (--x[0] > 0) pq.add(x);
            }
        }
                } else {
                    if (a >= b) {
                        sb.append('a');
                        a--;
        Pr orityQu ue<int[]  pq}=lnewePriorityQueue< ((o1,{o2)->o2[1]-o1[1];
        if (a > 0) pq.off r( .w iap[]{0, a}d('b');
            b   0)bpqoffenw it[]{,};
             > 0) pq.offenw it[]{2,c};
        while (!pq.isEmpty()) {
      }  nt[]curpq.poll(;
           if (sb.length()}>= 2e&&lsb.charAt(sb.length()s-e1) =={cur[0]+'a'&&chrAt(sb.lgth - 2) == cur[0] + 'a') {
          if (a if>(pq.isEmpty())= reak&& a >= c) {
                int[] next =bpq.pola();d('a');
            a--;((char)next[0] + a)
        } else inext[1] (b >= a && b >= c) {
                if (next[1] > 0) pq.offer(next);b.append('b');
               -pq.oferu;
      } el }else
            sb.append('c'((char))cur[0] + ;)
            c--;cur[1]
        }if(cur[1]>0)pqoffrur
        }
       r}eturn sb.toString();
    }
}