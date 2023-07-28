class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        int n = recipes.length;
        List<String> ans = new ArrayList<>();
        boolean[] isAvailable = new boolean[n];
        boolean[] isVisited = new boolean[n];
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies) {
            supplySet.add(s);
        }
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (isAvailable(i, ingredients.get(i), supplySet)) {
                ans.add(recipes[i]);
                isAvailable[i] = true;
            }
            isVisited[i] = true;
        }
        return ans;
    }
    
    private boolean isAvailable(int recipe, List<String> ingredients, Set<String> supplies) {
        boolean available = true;
        for (String s : ingredients) {
            if (!supplies.contains(s)) {
                available = false;
                break;
            }
        }
        return available;
    }
}