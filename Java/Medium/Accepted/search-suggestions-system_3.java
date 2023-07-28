class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            String s = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(s)) {
                    list.add(product);
                    if (list.size() == 3) {
                        break;
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}