class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            String str = searchWord.substring(0, i);
            for (String s : products) {
                if (s.startsWith(str)) {
                    list.add(s);
                    if (list.size() == 3) {
                        break;
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}