class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i != j && isSubset(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                indexes.add(i);
            }
        }
        return indexes;
    }
    
    private boolean isSubset(List<String> list1, List<String> list2) {
        Set<String> set = new HashSet<>(list2);
        for (String s : list1) {
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}