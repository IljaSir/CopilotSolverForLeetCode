class Solution {
    public int[] groupStrings(String[] words) {
        
        int[] ans = new int[2];
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : words){
            String key = getKey(word);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        for(List<String> list : map.values()){
            ans[0]++;
            ans[1] = Math.max(ans[1], list.size());
        }
        return ans;
    }
    private String getKey(String word){
        char[] chars = word.toCharArray();
        int diff = chars[0] - 'a';
        for(int i = 0; i < chars.length; i++){
            chars[i] = (char)(chars[i] - diff);
            if(chars[i] < 'a'){
                chars[i] = (char)(chars[i] + 26);
            }
        }
        return new String(chars);
    }
}