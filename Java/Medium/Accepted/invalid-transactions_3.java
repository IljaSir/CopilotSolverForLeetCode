class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < transactions.length; i++) {
            String[] t = transactions[i].split(",");
            if (Integer.parseInt(t[2]) > 1000) {
                result.add(transactions[i]);
                continue;
            }
            for (int j = 0; j < transactions.length; j++) {
                if (i == j) {
                    continue;
                }
                String[] t2 = transactions[j].split(",");
                if (t[0].equals(t2[0]) && !t[3].equals(t2[3]) && Math.abs(Integer.parseInt(t[1]) - Integer.parseInt(t2[1])) <= 60) {
                    result.add(transactions[i]);
                    break;
                }
            }
        }
        return result;
    }
}