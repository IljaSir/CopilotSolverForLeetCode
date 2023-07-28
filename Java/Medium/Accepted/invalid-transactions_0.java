class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] transaction = transactions[i].split(",");
            if (Integer.parseInt(transaction[2]) > 1000) {
                result.add(transactions[i]);
                continue;
            }
            for (int j = 0; j < transactions.length; j++) {
                if (j != i) {
                    String[] anotherTransaction = transactions[j].split(",");
                    if (transaction[0].equals(anotherTransaction[0]) && Math.abs(Integer.parseInt(transaction[1]) - Integer.parseInt(anotherTransaction[1])) <= 60 && !transaction[3].equals(anotherTransaction[3])) {
                        result.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return result;
    }
}