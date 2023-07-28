impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut current = Vec::new();
        let mut candidates = candidates;
        candidates.sort();
        Self::backtrack(&candidates, 0, target, &mut current, &mut result);
        result
    }

    fn backtrack(candidates: &Vec<i32>, start: usize, target: i32, current: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target == 0 {
            result.push(current.clone());
            return;
        }

        for i in start..candidates.len() {
            if target - candidates[i] < 0 {
                break;
            }
            current.push(candidates[i]);
            Self::backtrack(candidates, i, target - candidates[i], current, result);
            current.pop();
        }
    }
}