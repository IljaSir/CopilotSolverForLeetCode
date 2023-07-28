impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut result = Vec::new();
        let mut path = Vec::new();
        Solution::backtrack(&candidates, target, 0, &mut path, &mut result);
        result
    }
    fn backtrack(candidates: &Vec<i32>, target: i32, start: usize, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target < 0 {
            return;
        } else if target == 0 {
            result.push(path.clone());
            return;
        }
        for i in start..candidates.len() {
            if i > start && candidates[i] == candidates[i-1] {
                continue;
            }
            path.push(candidates[i]);
            Solution::backtrack(candidates, target - candidates[i], i+1, path, result);
            path.pop();
        }
    }
}