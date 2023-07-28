impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort_unstable();
        let mut result = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(&mut result, &candidates, target, &mut path, 0);
        result
    }
    fn backtrack(result: &mut Vec<Vec<i32>>, candidates: &Vec<i32>, target: i32, path: &mut Vec<i32>, start: usize) {
        if target == 0 {
            result.push(path.clone());
            return;
        }
        if target < 0 {
            return;
        }
        for i in start..candidates.len() {
            if i > start && candidates[i] == candidates[i - 1] {
                continue;
            }
            path.push(candidates[i]);
            Self::backtrack(result, candidates, target - candidates[i], path, i + 1);
            path.pop();
        }
    }
}