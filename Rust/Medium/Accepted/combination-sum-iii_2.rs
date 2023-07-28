impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Self::dfs(1, k, n, &mut path, &mut res);
        res
    }

    fn dfs(start: i32, k: i32, n: i32, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if k == 0 {
            if n == 0 {
                res.push(path.clone());
            }
            return;
        }
        for i in start..=9 {
            if i > n {
                break;
            }
            path.push(i);
            Self::dfs(i + 1, k - 1, n - i, path, res);
            path.pop();
        }
    }
}