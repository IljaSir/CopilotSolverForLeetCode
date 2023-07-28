impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in 1..n {
            res.push(i);
        }
        res.push(-(n - 1) * n / 2);
        res
    }
}