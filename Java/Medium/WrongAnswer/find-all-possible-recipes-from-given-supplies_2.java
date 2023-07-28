class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> result = new ArrayList<>();
        Set<String> supplySet = new HashSet<>();
        for (String supply : supplies) {
            supplySet.add(supply);
        }
        for (int i = 0; i < recipes.length; i++) {
            List<String> ingredientList = ingredients.get(i);
            boolean canMake = true;
            for (String ingredient : ingredientList) {
                if (!supplySet.contains(ingredient)) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) {
                result.add(recipes[i]);
            }
        }
        return result;
    }
}