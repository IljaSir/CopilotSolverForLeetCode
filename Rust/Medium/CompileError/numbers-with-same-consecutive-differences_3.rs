impl Solution {
    pub fn nums_same_consec_diff(n: i32, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut dfs = |n: i32, num: i32| {
            if n == 0 {
                res.push(num);
                return;
            }
            let prev = num % 10;
            if prev + k < 10 {
                dfs(n - 1, num * 10 + prev + k);
            }
            if k > 0 && prev - k >= 0 {
                dfs(n - 1, num * 10 + prev - k);
            }
        };
        if n == 1 {
            res.push(0);
        }
        for i in 1..10 {
            dfs(n - 1, i);
        }
        res
    }
}