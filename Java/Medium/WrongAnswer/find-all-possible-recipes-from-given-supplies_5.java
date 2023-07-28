class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<>();
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies) {
            supplySet.add(s);
        }
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingredient = ingredients.get(i);
            boolean canMake = true;
            for (String s : ingredient) {
                if (!supplySet.contains(s)) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) {
                ans.add(recipe);
            }
        }
        return ans;
    }
}