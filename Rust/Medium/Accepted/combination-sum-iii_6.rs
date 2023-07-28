impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut temp = vec![];
        Self::dfs(1, k, n, &mut res, &mut temp);
        res
    }
    fn dfs(start: i32, k: i32, n: i32, res: &mut Vec<Vec<i32>>, temp: &mut Vec<i32>) {
        if k == 0 && n == 0 {
            res.push(temp.clone());
            return;
        }
        if k < 0 || n < 0 {
            return;
        }
        for i in start..10 {
            temp.push(i);
            Self::dfs(i + 1, k - 1, n - i, res, temp);
            temp.pop();
        }
    }
}