impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut comb = Vec::new();
        Self::dfs(1, n, k, &mut comb, &mut res);
        res
    }
    fn dfs(i: i32, n: i32, k: i32, comb: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if comb.len() as i32 == k {
            res.push(comb.clone());
            return;
        }
        for j in i..=n {
            comb.push(j);
            Self::dfs(j + 1, n, k, comb, res);
            comb.pop();
        }
    }
}