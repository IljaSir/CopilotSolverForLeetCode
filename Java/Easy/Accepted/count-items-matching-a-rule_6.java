class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int rule = 0;
        if (ruleKey.equals("color")) {
            rule = 1;
        } else if (ruleKey.equals("name")) {
            rule = 2;
        }
        int count = 0;
        for (List<String> item : items) {
            if (item.get(rule).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}