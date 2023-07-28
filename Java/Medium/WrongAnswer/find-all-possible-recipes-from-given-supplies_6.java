class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, Integer> supplyMap = new HashMap<>();
        for (String s : supplies) {
            supplyMap.put(s, supplyMap.getOrDefault(s, 0) + 1);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < recipes.length; i++) {
            if (canMake(supplyMap, ingredients.get(i))) {
                res.add(recipes[i]);
            }
        }
        return new ArrayList<>(res);
    }
    
    private boolean canMake(Map<String, Integer> supplyMap, List<String> recipe) {
        Map<String, Integer> recipeMap = new HashMap<>();
        for (String s : recipe) {
            recipeMap.put(s, recipeMap.getOrDefault(s, 0) + 1);
        }
        for (String s : recipeMap.keySet()) {
            if (supplyMap.getOrDefault(s, 0) < recipeMap.get(s)) {
                return false;
            }
        }
        return true;
    }
}