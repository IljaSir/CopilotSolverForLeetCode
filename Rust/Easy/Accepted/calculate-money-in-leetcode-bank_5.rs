impl Solution {
    pub fn total_money(n: i32) -> i32 {
        
        let mut res = 0;
        let mut t = 0;
        for i in 1..n+1 {
            if i % 7 == 1 {
                t = i / 7 + 1;
            }
            res += t;
            t += 1;
        }
        res
    }
}