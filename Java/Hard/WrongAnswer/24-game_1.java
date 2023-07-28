class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        next.add(list.get(k));
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && j == i + 1) {
                        continue;
                    }
                    if (k == 0) {
                        next.add(list.get(i) + list.get(j));
                    } else if (k == 1) {
                        next.add(list.get(i) * list.get(j));
                    } else if (k == 2) {
                        next.add(list.get(i) - list.get(j));
                    } else {
                        if (Math.abs(list.get(j)) < 1e-6) {
                            continue;
                        }
                        next.add(list.get(i) / list.get(j));
                    }
                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}