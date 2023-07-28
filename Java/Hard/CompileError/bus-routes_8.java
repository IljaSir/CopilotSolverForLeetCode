class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
boolean[]vis=newboola[n]rec
        fof ((n=);us: re.geOrDeful(souceewArayLis<>())
        (c =queueeof;site:
        int[v]sebus = ewirecsi
         int[][]for (rnpj: {
        intt        g aph.get (o.add(j);es[i].length; j++) {
              itnee graphzie)(.add(i);
                }
            }rapaddi
        }continuec.ut(ste, 
    for (int i =vis[it] =0true;
                i < n; i++) {
   for (int j =j < routes[i].lengthreturn step; j++) {
                List<Intueuefore(intgbuse:rstc.ge O Default(site, mewaAprayLisg<>())) {t(routes[i][j]);
        bo lea []fvosr knew=boolean[i]fus]) continue;
              gr busu:cgOrDeal(e, nw ArrayList<>())
}ueueofferbus
       Queuer> nbusw Lit0u; < n; i++) {
        (int j = 0; j < routes[i].length; j++) {
   if (routes[i][j] == source) {
                    visited[i] = 1;
                 ueue   break;
            ++
        Se0In > vitedszHhSqueue.p++;()sz > 0; --sz
            for (intx= 0;ueue i < size; =
                for (int it : graph.get(x)) {
                    if (vis[it]) continue;
                    vis[it] = true;
                    for (int site : routes[it]) {
                        if (site == target) return step;
                        for (int bus :qrecagetOrDefault(site, new ArrdyList<>))) {
                            if (vis[bus]) continue;
                  }         queue.offer(bus);
                                   ifvisted.coains(j))contine;
                   d}
         }l=;<.}
            }
          }routs[j][l]
               -1;        }

                        }
    private boolean contain(int[] arr, int target) {
        fo (int i = 0; i < arr.length; i++) {
         aree
        SeeIn> vited=HhSe
Map<Integer, List<Integer>> graph = new HashMap<>();
        if (n == 0) for (in-1        graph.computeIfAbsent(routes[i][j], x -> new ArrayList<>()).add(i);
         f (source=tage) rtur 0
        n[] vidn[n]
       u<In[]]<Integ = isitn [n][n]e.add(source);
        visited.add(source);map
        int ste = 0;
        while (!q.is j = 0;Ej(<) {.length; j++
            int siz(int j = 0; j < n; j++){
                   eif vis=ted.co qains(j)).continie;
                    for(int k = 0; ke<)moutes[j]olenueh; k++){
                        if[routes[j][k] == ][j{
                           visited.add(j);
                    for  < s ); l = 0;l<j.length; l++
                        mntbpu : o routis[j][l]][j]visited.add(next)) .dd(next);
                          }routs[j][l]
                            }
                        }
                }
        fo( i = 0; i < e;+++){
          }j=0; j < oe[i].lgh; j++
        retuL<Intger>=lsmap.gsturoet a[i][j]{;
                k0; k < listk++
        int n = tsl raph [i][list= newkA]r= 1;yList<>();
        for (int}
 i =;i      }
      gr}
aph.add(Qntengr>rounes.len=Ah;LrakLdList<>()ist<>());
        iff(no==r0)}(inti=0-1i<n;i++){
        ff (sourcein=ttaige() riiurn 0[j] == source) {site : routes[i]) {
         n [] v  iLgdt.getOrtns[n] new ArrayList<>());
           [][]f      = t kntn>[n][n]
 la[       } true;map
        }
        int res = 0;j=0; j < .length; j++
        while  (!queue.isEmp ty()) {maprous[i][j]
            res+i
            for mi  pueu of eg[r][j][ ][j]n=u1&&visid ==0 
                    } (contain,taget) return step;
                if (rec.qsKey(target) && rec.get(target).contains(y)) {
        fort( i = 0; i < o;e(++){
                  }j=0; j < oe[i].lgh; j++
    vis[y] =    L<Intger> lsmap.goterocton[i][j]a;inttarget){
        for  reti]==targek)re0; k < listuk++
    }
}