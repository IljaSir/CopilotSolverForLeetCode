class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, Set<String>> recipeMap = new HashMap<>();
        Map<String, Integer> supplyMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                recipeMap.putIfAbsent(ingredient, new HashSet<>());
                recipeMap.get(ingredient).add(recipe);
            }
        }
        for (String supply : supplies) {
            supplyMap.put(supply, supplyMap.getOrDefault(supply, 0) + 1);
        }
        Set<String> result = new HashSet<>();
        for (String supply : supplies) {
            if (recipeMap.containsKey(supply)) {
                for (String recipe : recipeMap.get(supply)) {
                    result.add(recipe);
                }
            }
        }
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
}