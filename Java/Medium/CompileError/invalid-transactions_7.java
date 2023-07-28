class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> invalidTransactions = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            if (t.amount > 1000) {
                invalidTransactions.add(transaction);
            }
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }
        for (List<Transaction> list : map.values()) {
            Collections.sort(list, (a, b) -> a.time - b.time);
            for (int i = 0; i < list.size(); i++) {
                Transaction t = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    Transaction t2 = list.get(j);
                    if (t2.time - t.time > 60) {
                        break;
                    }
                    if (!t.city.equals(t2.city)) {
                        invalidTransactions.add(t.toString());
                        invalidTransactions.add(t2.toString());
                    }
                }
            }
        }
        return invalidTransactions;
    }
}
    }
}