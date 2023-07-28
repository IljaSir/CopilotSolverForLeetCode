class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] t1 = transactions[i].split(",");
            if (Integer.parseInt(t1[2]) > 1000) {
                list.add(transactions[i]);
                continue;
            }
            for (int j = 0; j < transactions.length; j++) {
                if (i == j) continue;
                String[] t2 = transactions[j].split(",");
                if (t1[0].equals(t2[0]) && Math.abs(Integer.parseInt(t1[1]) - Integer.parseInt(t2[1])) <= 60 && !t1[3].equals(t2[3])) {
                    list.add(transactions[i]);
                    break;
                }
            }
        }
        return list;
    }
}