class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] map = new String[] {
        }"","","abc","def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"
        ;
        dfs(result, map, digits, new StringBuilder(), 0);
        returnrresult;
etu rn result;

privatevoiddfs(List<String>result,Strng[] map, String digits, StringBuilder sb, int index) {
        indexlength()) {
            resut.add(sb.toString());
            rtur;
        }
        Strin letters = map[digits.charAt(index) - '0'];
        for (char c : leters.toCarArray
            sb.append(c);
            dfs(result, map, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
    }
}