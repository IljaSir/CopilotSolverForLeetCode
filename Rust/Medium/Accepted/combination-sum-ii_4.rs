impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut res = vec![];
        Self::backtrack(&candidates, 0, target, &mut vec![], &mut res);
        res
    }
    
    fn backtrack(candidates: &Vec<i32>, start: usize, target: i32, cur: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if target == 0 {
            res.push(cur.clone());
            return;
        }
        for i in start..candidates.len() {
            if candidates[i] > target {
                break;
            }
            if i > start && candidates[i] == candidates[i-1] {
                continue;
            }
            cur.push(candidates[i]);
            Self::backtrack(candidates, i+1, target-candidates[i], cur, res);
            cur.pop();
        }
    }
}