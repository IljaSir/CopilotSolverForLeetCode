impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut result = vec![];
        Solution::combination_sum2_rec(&candidates, target, &mut result, vec![]);
        result
    }
    fn combination_sum2_rec(candidates: &Vec<i32>, target: i32, result: &mut Vec<Vec<i32>>, mut current: Vec<i32>) {
        if target == 0 {
            result.push(current);
            return;
        }
        if candidates.is_empty() {
            return;
        }
        let mut i = 0;
        while i < candidates.len() {
            if candidates[i] > target {
                break;
            }
            let mut j = i + 1;
            while j < candidates.len() && candidates[j] == candidates[i] {
                j += 1;
            }
            current.push(candidates[i]);
            Solution::combination_sum2_rec(&candidates[j..].to_vec(), target - candidates[i], result, current.clone());
            current.pop();
            i = j;
        }
    }
}