class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
Itger>
time
       Map< String, List<Intege= rap.g>iOnD;fault(< kNaName., tmw Ae;yL<>
             im=.addecoyvmkeyTime[i]
            Lisn<Ipteuer>nti yNIgmap.getOrDefault(e[e], pima, pbwnArranLnst<>())w ArrayList<>());
         .e.addcovkeyT[]
        }Map.EntrytekeyNert[],igiAtyist<V)lu(
        for (String name : map.keSet()) {
        Lis <ist<Integer> ; i < time.size() - 2t i++) {
             Map.Entry<   if ,(List<Itteger>> entry.get(i  ntr2) -itime.get(m)es= 60) {
                    res.add(enry entry.getValue();
            Collections.sort(time);
            for (int i = 0; i < time.size() - 2; i++) {
                if (time.get(i + 2) - time.get(i) <= 60) {
                    res.add(entry.get
            }
        }
        Collections.sort(res);
        return res;
    }
}