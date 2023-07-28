impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut path = vec![];
        let mut sum = 0;
        Self::dfs(1, k, n, &mut path, &mut res, &mut sum);
        res
    }
    fn dfs(start: i32, k: i32, n: i32, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>, sum: &mut i32) {
        if path.len() == k as usize && *sum == n {
            res.push(path.clone());
            return;
        }
        for i in start..=9 {
            if *sum > n {
                return;
            }
            path.push(i);
            *sum += i;
            Self::dfs(i + 1, k, n, path, res, sum);
            path.pop();
            *sum -= i;
        }
    }
}