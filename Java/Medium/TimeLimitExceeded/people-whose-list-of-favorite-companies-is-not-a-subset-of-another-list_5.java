class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<favoriteCompanies.size(); i++) {
            boolean flag = true;
            for(int j=0; j<favoriteCompanies.size(); j++) {
                if(i==j) continue;
                if(favoriteCompanies.get(i).size() < favoriteCompanies.get(j).size()) {
                    if(favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                result.add(i);
            }
        }
        return result;
    }
}