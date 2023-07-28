impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut path = vec![];
        Self::dfs(k, n, 1, &mut res, &mut path);
        res
    }
    fn dfs(k: i32, n: i32, start: i32, res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>) {
        if path.len() == k as usize && n == 0 {
            res.push(path.clone());
            return;
        }
        for i in start..10 {
            if i > n {
                break;
            }
            path.push(i);
            Self::dfs(k, n - i, i + 1, res, path);
            path.pop();
        }
    }
}