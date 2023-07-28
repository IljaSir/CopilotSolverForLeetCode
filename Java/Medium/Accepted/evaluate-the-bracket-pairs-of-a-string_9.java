class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        HashMap<String, String> map = new HashMap<>();
        for(List<String> l : knowledge){
            map.put(l.get(0), l.get(1));
        }
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '('){
                StringBuffer key = new StringBuffer();
                while(s.charAt(++i) != ')'){
                    key.append(s.charAt(i));
                }
                if(map.containsKey(key.toString())){
                    sb.append(map.get(key.toString()));
                }else{
                    sb.append('?');
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}