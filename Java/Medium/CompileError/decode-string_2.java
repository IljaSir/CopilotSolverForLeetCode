class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int start = idx;
                while(Character.isDigit(s.charAt(idx))){
                    idx++;
                }
                count.push(Integer.parseInt(s.substring(start, idx)));
            }else if(s.charAt(idx) == '['){
                result.push(res);
                res = "";
                idx++;
            }else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(result.pop());
                int times = count.pop();
                for(int i = 0; i < times; i++){
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }
}