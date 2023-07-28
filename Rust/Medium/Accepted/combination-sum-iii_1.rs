impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut path = vec![];
        Self::dfs(1, k, n, &mut path, &mut res);
        res
    }

    fn dfs(start: i32, k: i32, n: i32, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if n == 0 && path.len() == k as usize {
            res.push(path.clone());
            return;
        }
        if n < 0 || path.len() == k as usize {
            return;
        }
        for i in start..=9 {
            path.push(i);
            Self::dfs(i + 1, k, n - i, path, res);
            path.pop();
        }
    }
}