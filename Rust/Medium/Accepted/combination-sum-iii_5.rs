impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(&mut res, &mut path, n, k, 1);
        res
    }

    fn backtrack(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, n: i32, k: i32, start: i32) {
        if n == 0 && k == 0 {
            res.push(path.clone());
            return;
        }
        if n < 0 || k < 0 {
            return;
        }
        for i in start..10 {
            path.push(i);
            Self::backtrack(res, path, n - i, k - 1, i + 1);
            path.pop();
        }
    }
}