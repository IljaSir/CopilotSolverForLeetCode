class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //sort products
        Arrays.sort(products);
        
        //create a list of list of string
        List<List<String>> result = new ArrayList<>();
        
        //create a stringbuilder
        StringBuilder sb = new StringBuilder();
        
        //loop through the search word
        for (char c : searchWord.toCharArray()) {
            //append the character to the stringbuilder
            sb.append(c);
            
            //create a list of string
            List<String> temp = new ArrayList<>();
            
            //loop through the products
            for (String product : products) {
                //if the product starts with the stringbuilder
                if (product.startsWith(sb.toString())) {
                    //add the product to the list
                    temp.add(product);
                }
                
                //if the list has 3 elements
                if (temp.size() == 3) {
                    //break out of the loop
                    break;
                }
            }
            
            //add the list to the result
            result.add(temp);
        }
        
        //return the result
        return result;
    }
}