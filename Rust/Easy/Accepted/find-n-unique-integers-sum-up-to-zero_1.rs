impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        if n % 2 == 1 {
            res.push(0);
        }
        for i in 1..=n/2 {
            res.push(i);
            res.push(-i);
        }
        res
    }
}