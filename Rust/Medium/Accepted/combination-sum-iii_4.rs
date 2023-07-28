impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut tmp = Vec::new();
        Solution::backtrack(k, n, 1, &mut tmp, &mut res);
        res
    }
    fn backtrack(k: i32, n: i32, start: i32, tmp: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if k == 0 {
            if n == 0 {
                res.push(tmp.clone());
            }
            return;
        }
        for i in start..10 {
            tmp.push(i);
            Solution::backtrack(k - 1, n - i, i + 1, tmp, res);
            tmp.pop();
        }
    }
}