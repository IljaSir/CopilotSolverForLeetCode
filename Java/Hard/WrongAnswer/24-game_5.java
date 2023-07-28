class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return judgePoint24(list);
    }

    private boolean judgePoint24(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;
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
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == 0) {
                        next.add(list.get(i) + list.get(j));
                    } else if (k == 1) {
                        next.add(list.get(i) * list.get(j));
                    } else if (k == 2) {
                        next.add(list.get(i) - list.get(j));
                    } else {
                        if (list.get(j) < 0.001) {
                            continue;
                        }
                        next.add(list.get(i) / list.get(j));
                    }
                    if (judgePoint24(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}