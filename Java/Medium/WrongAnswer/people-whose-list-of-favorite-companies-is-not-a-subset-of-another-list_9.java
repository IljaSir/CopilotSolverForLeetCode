class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> result = new ArrayList<>();
        int len = favoriteCompanies.size();
        int[] set = new int[len];
        for (int i = 0; i < len; i++) {
            for (String s : favoriteCompanies.get(i)) {
                set[i] |= (1 << (s.hashCode() % 32));
            }
        }
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (i != j && (set[i] & set[j]) == set[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}