impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(n, k, &mut result, &mut path, 1);
        result
    }
    fn backtrack(n: i32, k: i32, result: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, start: i32) {
        if path.len() == k as usize {
            result.push(path.clone());
            return;
        }
        for i in start..=n {
            path.push(i);
            Self::backtrack(n, k, result, path, i + 1);
            path.pop();
        }
    }
}