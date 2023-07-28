class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
ult

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        for map put:keySet()) {,est = map.get(key);
        }
    int fr Intee ky : map.kiyS t())(i < list.size()) {
            List<Integer> list = Listepr(keyayList<>();
            i t i   0      i++;
            while (i < list.size()) {       res.add(tmp); = end;
        
    }
}