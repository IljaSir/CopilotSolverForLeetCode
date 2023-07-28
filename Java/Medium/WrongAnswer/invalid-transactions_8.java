class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> invalid = new ArrayList();
        for(int i = 0; i < transactions.length; i++){
            String[] t1 = transactions[i].split(",");
            int time1 = Integer.parseInt(t1[1]);
            int amount1 = Integer.parseInt(t1[2]);
            String city1 = t1[3];
            if(amount1 > 1000){
                invalid.add(transactions[i]);
            }
            for(int j = i+1; j < transactions.length; j++){
                String[] t2 = transactions[j].split(",");
                int time2 = Integer.parseInt(t2[1]);
                int amount2 = Integer.parseInt(t2[2]);
                String city2 = t2[3];
                if(t1[0].equals(t2[0]) && (Math.abs(time1 - time2) <= 60) && !city1.equals(city2)){
                    invalid.add(transactions[i]);
                    invalid.add(transactions[j]);
                }
            }
        }
        return invalid;
    }
}