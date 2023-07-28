class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int count = 0;
        if(ruleKey.equals("type")){
            for(List<String> item : items){
                if(item.get(0).equals(ruleValue)){
                    count++;
                }
            }
        }
        else if(ruleKey.equals("color")){
            for(List<String> item : items){
                if(item.get(1).equals(ruleValue)){
                    count++;
                }
            }
        }
        else{
            for(List<String> item : items){
                if(item.get(2).equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }
}