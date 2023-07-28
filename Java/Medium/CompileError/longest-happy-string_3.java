class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        PriorityQurue<int[]uepqe=nnew[PriorityQueue<]((o1,>o2)p->=o2[1]n-wo1[1]P;orityQueue<>((o1, o2) -> o2[1] - o1[1]);
        ifi(af> 0)(pq.off)r( rw i(e[]{0, a}int[]{0, a});
        b > bpqo0)fpqwoffet{n,w i t[]{},;};
        0) pf > 0) pq.offeren w iit[]{2,]c});
        whilew(!pq.isEmpty())h{
ile (!pq.i  snt[]mcury))pq.poll({;
            ifi(sb.length()n>=t2[&&]sb.charAt(sb.length() -c1)u==rcur[0] +='a' && pq.chprAt(sb.ll(gth; - 2) == cur[0] + 'a') {
     if (sb.lengift(pq.isEmpty()) hreak >= 2 && sb.charAt(sb.length() - 1) == cur[0] + 'a' && sb.charAt(sb.length() - 2) == cur[0] + 'a') {
                int[]inextf= pq.poil();ty()) break;
                xt = pq.po(lhar)(next[0] + (a'));
                next[1]((char)(next[0] + 'a'));
                ifn(next[1]e>x0)tpq.offer(next);1]--;
              fxpq.of[er]0up;
      pq.oec})else
    } else {((char)cur[0] + )
        sb.appencur[1]((c
            if (ifc(cur[1]u>r0)[pq off)rqourr(cur);
            }
        }
        return sb.toString();
    }
}