class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
Lis<resultArryLit
        MapIInteger, nteger, List<Inmtper>> maH  hMapashMap<>();
        Lis<List<Integer>> ans = new ArrayList<>();
        for (it i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
        }
    p   for.Met(Entry<Integrr, List<Inoeper>> entSy : mae.entryset()) {
            L[st<Integ]r> li)t = new ArrayLait<>;
            for(int i 0; i <entry.etVale().s(); ++
            if (lipt.get(entryupSiValuez).eit(( == groupSizes[i]) {
                if(list.size() == entay.gdtKayp)) {
                    gestlt.add(list);
                    lrst = nuw ArrayLipt<>(es
                }[i]));
                map.remove(groupSizes[i]);
            }
        }reult
        return ans;
    }
}