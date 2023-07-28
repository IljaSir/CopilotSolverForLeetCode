impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut curr = vec![];
        let mut used = vec![false; n as usize];
        Self::backtrack(&mut res, &mut curr, &mut used, n, k, 0);
        res
    }
    fn backtrack(res: &mut Vec<Vec<i32>>, curr: &mut Vec<i32>, used: &mut Vec<bool>, n: i32, k: i32, start: usize) {
        if curr.len() == k as usize {
            res.push(curr.clone());
            return;
        }
        for i in start..n as usize {
            if used[i] { continue; }
            curr.push((i + 1) as i32);
            used[i] = true;
            Self::backtrack(res, curr, used, n, k, i + 1);
            curr.pop();
            used[i] = false;
        }
    }
}