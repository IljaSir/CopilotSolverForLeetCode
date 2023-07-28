impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Solution::backtrack(&mut res, &mut path, &candidates, target, 0);
        res
    }

    fn backtrack(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, candidates: &Vec<i32>, target: i32, start: usize) {
        if target < 0 {
            return;
        }
        if target == 0 {
            res.push(path.clone());
            return;
        }
        for i in start..candidates.len() {
            path.push(candidates[i]);
            Solution::backtrack(res, path, candidates, target - candidates[i], i);
            path.pop();
        }
    }
}