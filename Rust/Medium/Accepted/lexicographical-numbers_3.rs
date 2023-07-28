impl Solution {
    pub fn lexical_order(n: i32) -> Vec<i32> {
        

        let mut res = Vec::new();
        let mut x = 1;
        for _ in 0..n {
            res.push(x);
            if x * 10 <= n {
                x *= 10;
            } else {
                if x == n {
                    x /= 10;
                }
                x += 1;
                while x % 10 == 0 {
                    x /= 10;
                }
            }
        }
        res
    }
}