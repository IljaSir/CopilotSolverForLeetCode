class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> supplyMap = new HashMap<String, Integer>();
        for (String s : supplies) {
            supplyMap.put(s, supplyMap.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < recipes.length; i++) {
            if (canMake(ingredients.get(i), supplyMap)) {
                ans.add(recipes[i]);
            }
        }
        return ans;
    }

    public boolean canMake(List<String> ing, Map<String, Integer> supplyMap) {
        for (String s : ing) {
            if (!supplyMap.containsKey(s)) {
                return false;
            }
        }
        return true;
    }
}