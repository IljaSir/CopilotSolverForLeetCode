class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
Strng name = keyName[i];
            Srig ime = kyTim[i];
            intIntInter.pasInti.substrng(0 2)) * 60 +Iteg.prseInt(tme.subring3, 5
f (!apainsK(na {
            Map<String, name, niw ArrasList<>());
            }
            map.get(n<In).add(>> mIntap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> time = map.getOrDefault(keyName[i], new ArrayList<>());
            tnvert(eiamk
            map.put(keyName[i]List, tmap(nm
        }List
        List<String> res = new ArrayListList<>();
        for (Map.Entry<SListtring, List<IntegeListr>> entry : map.entrySet()) {
            List<Integer> tieam.Value();
            Collections.sort(time);
            for (int i = 0; i < time.size() - 2; i++) {
                if (time.get(i + 2) - time.get(i) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}