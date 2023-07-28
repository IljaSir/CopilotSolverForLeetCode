class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return helper(list);
    }
    private boolean helper(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        next.add(list.get(k));
                    }
                }
                for (int k = 0; k < 6; k++) {
                    if (k < 4 && i > j) {
                        continue;
                    }
                    if (k == 0) {
                        next.add(list.get(i) + list.get(j));
                    } else if (k == 1) {
                        next.add(list.get(i) * list.get(j));
                    } else if (k == 2) {
                        next.add(list.get(i) - list.get(j));
                    } else if (k == 3) {
                        if (list.get(j) != 0) {
                            next.add(list.get(i) / list.get(j));
                        } else {
                            continue;
                        }
                    } else if (k == 4) {
                        next.add(list.get(j) - list.get(i));
                    } else if (k == 5) {
                        if (list.get(i) != 0) {
                            next.add(list.get(j) / list.get(i));
                        } else {
                            continue;
                        }
                    }
                    if (helper(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}