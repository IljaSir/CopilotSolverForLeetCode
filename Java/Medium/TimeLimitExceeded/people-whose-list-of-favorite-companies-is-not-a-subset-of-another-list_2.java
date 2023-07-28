class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < favoriteCompanies.size(); i++){
            boolean isSubset = false;
            for(int j = 0; j < favoriteCompanies.size(); j++){
                if(i != j){
                    if(favoriteCompanies.get(i).size() < favoriteCompanies.get(j).size()){
                        if(favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))){
                            isSubset = true;
                            break;
                        }
                    }
                }
            }
            if(!isSubset){
                result.add(i);
            }
        }
        return result;
    }
}