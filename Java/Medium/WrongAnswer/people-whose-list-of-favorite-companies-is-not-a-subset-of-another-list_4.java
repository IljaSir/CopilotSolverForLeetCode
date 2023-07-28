class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (String c : favoriteCompanies.get(i)) {
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<>());
                }
                map.get(c).add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (String c : favoriteCompanies.get(i)) {
                if (map.get(c).size() > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }
}