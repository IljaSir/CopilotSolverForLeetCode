class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> resultult = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        for (Map.Entry<Map.Ent,rList<Int<ger>> entrInteger,Lntrist<Integer>> entry : map.entrySet()) {
            List<Integer> list = entryry.gValuV(lue();
            int sszeize<ntryeg=tKey n;ArrayList<>();
            (Integer i : liest) {
            for (Integer i : ltsm)p{);
                ttmp.addmi);= size) {
                if (reesu(iz r) == srzea {ist<>(temp));
                    result.add(new ArrayList<>(temp))p.clear();
                }temp.clear()
            }
        }rn result;
    }
}