impl Solution {
    pub fn nums_same_consec_diff(n: i32, k: i32) -> Vec<i32> {
        
        let mut result = vec![];
        for i in 1..10 {
            Self::dfs(n - 1, i, k, &mut result);
        }
        result
    }
    fn dfs(n: i32, num: i32, k: i32, result: &mut Vec<i32>) {
        if n == 0 {
            result.push(num);
            return;
        }
        let last = num % 10;
        if last - k >= 0 {
            Self::dfs(n - 1, num * 10 + last - k, k, result);
        }
        if k != 0 && last + k < 10 {
            Self::dfs(n - 1, num * 10 + last + k, k, result);
        }
    }
}