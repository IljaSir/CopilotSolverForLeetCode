impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut candidates = candidates;
        candidates.sort();
        let mut path = Vec::new();
        Self::backtrack(&candidates, target, &mut path, &mut result);
        result
    }
    fn backtrack(candidates: &[i32], target: i32, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target == 0 {
            result.push(path.to_vec());
            return;
        }
        for (i, &candidate) in candidates.iter().enumerate() {
            if target - candidate < 0 {
                break;
            }
            path.push(candidate);
            Self::backtrack(&candidates[i..], target - candidate, path, result);
            path.pop();
        }
    }
}