impl Solution {
    pub fn combination_sum3(k: i32, n: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        let mut used = vec![false; 10];
        Self::backtrack(&mut res, &mut path, &mut used, k, n, 1);
        res
    }

    fn backtrack(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, used: &mut Vec<bool>, k: i32, n: i32, start: i32) {
        if k == 0 {
            if n == 0 {
                res.push(path.clone());
            }
            return;
        }
        if n < 0 {
            return;
        }
        for i in start..=9 {
            if used[i as usize] {
                continue;
            }
            used[i as usize] = true;
            path.push(i);
            Self::backtrack(res, path, used, k - 1, n - i, i + 1);
            path.pop();
            used[i as usize] = false;
        }
    }
}