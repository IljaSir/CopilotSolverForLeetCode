class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, Set<String>> recipeMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], new HashSet<>(ingredients.get(i)));
        }
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (canMake(recipeMap, supplySet, recipes[i])) {
                result.add(recipes[i]);
            }
        }
        return result;
    }
    
    private boolean canMake(Map<String, Set<String>> recipeMap, Set<String> supplySet, String recipe) {
        if (supplySet.containsAll(recipeMap.get(recipe))) {
            return true;
        }
        for (String ingredient : recipeMap.get(recipe)) {
            if (!supplySet.contains(ingredient)) {
                if (canMake(recipeMap, supplySet, ingredient)) {
                    supplySet.add(ingredient);
                } else {
                    return false;
                }
            }
        }
        return supplySet.containsAll(recipeMap.get(recipe));
    }
}