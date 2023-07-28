impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut ans = vec![];
        let mut cur = vec![];
        Self::backtrack(&candidates, target, 0, &mut cur, &mut ans);
        ans
    }

    fn backtrack(candidates: &Vec<i32>, target: i32, start: usize, cur: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
        if target == 0 {
            ans.push(cur.clone());
            return;
        }
        if target < 0 {
            return;
        }
        for i in start..candidates.len() {
            cur.push(candidates[i]);
            Self::backtrack(candidates, target - candidates[i], i, cur, ans);
            cur.pop();
        }
    }
}