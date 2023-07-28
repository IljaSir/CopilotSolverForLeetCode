class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String transaction : transactions){
            String[] split = transaction.split(",");
            String name = split[0];
            String time = split[1];
            String amount = split[2];
            String city = split[3];
            
            List<String> list = map.getOrDefault(name, new ArrayList<>());
            list.add(transaction);
            map.put(name, list);
        }
        
        for(String transaction : transactions){
            String[] split = transaction.split(",");
            String name = split[0];
            String time = split[1];
            String amount = split[2];
            String city = split[3];
            
            if(Integer.parseInt(amount) > 1000){
                result.add(transaction);
            }else{
                List<String> list = map.get(name);
                for(String s : list){
                    String[] ssplit = s.split(",");
                    String stime = ssplit[1];
                    String scity = ssplit[3];
                    
                    if(!city.equals(scity) && Math.abs(Integer.parseInt(time) - Integer.parseInt(stime)) <= 60){
                        result.add(transaction);
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}