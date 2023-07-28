class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for (int card: cards) {
            list.add((double) card);
        }
        return solve(list);
    }
    
    private boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == 1) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == 2) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == 3) {
                            if (list.get(j) != 0) {
                                list2.add(list.get(i) / list.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}