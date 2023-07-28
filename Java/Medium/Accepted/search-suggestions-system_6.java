class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    list.add(product);
                }
            }
            Collections.sort(list);
            if (list.size() > 3) {
                list = list.subList(0, 3);
            }
            ans.add(list);
        }
        return ans;
    }
}