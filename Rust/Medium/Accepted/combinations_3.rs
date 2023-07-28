impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(&mut res, &mut path, 1, k, n);
        res
    }
    fn backtrack(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, start: i32, k: i32, n: i32) {
        if path.len() == k as usize {
            res.push(path.clone());
            return;
        }
        for i in start..=n {
            path.push(i);
            Self::backtrack(res, path, i + 1, k, n);
            path.pop();
        }
    }
}