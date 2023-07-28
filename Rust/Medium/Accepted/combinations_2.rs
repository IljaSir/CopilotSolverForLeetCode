impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut result = vec![];
        let mut current = vec![];
        Self::backtrack(&mut result, &mut current, n, k, 1);
        result
    }
    fn backtrack(result: &mut Vec<Vec<i32>>, current: &mut Vec<i32>, n: i32, k: i32, start: i32) {
        if current.len() == k as usize {
            result.push(current.clone());
            return;
        }
        for i in start..=n {
            current.push(i);
            Self::backtrack(result, current, n, k, i + 1);
            current.pop();
        }
    }
}