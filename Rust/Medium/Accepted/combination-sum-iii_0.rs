impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Self::dfs(k, n, 1, &mut path, &mut res);
        res
    }

    fn dfs(k: i32, n: i32, start: i32, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if k == 0 && n == 0 {
            res.push(path.clone());
            return;
        }
        for i in start..=9 {
            if i > n {
                break;
            }
            path.push(i);
            Self::dfs(k - 1, n - i, i + 1, path, res);
            path.pop();
        }
    }
}