class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] t1 = transactions[i].split(",");
            for (int j = i + 1; j < transactions.length; j++) {
                String[] t2 = transactions[j].split(",");
                if (t1[0].equals(t2[0]) && !t1[3].equals(t2[3]) && Math.abs(Integer.parseInt(t1[1]) - Integer.parseInt(t2[1])) <= 60) {
                    result.add(transactions[i]);
                    result.add(transactions[j]);
                }
            }
            if (Integer.parseInt(t1[2]) > 1000) {
                result.add(transactions[i]);
            }
        }
        return result;
    }
}