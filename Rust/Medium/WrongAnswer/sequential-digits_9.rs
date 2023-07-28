impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut n = 1;
        let mut m = 1;
        let mut x = 0;
        let mut y = 0;
        while x < high {
            x = x * 10 + n;
            n += 1;
            if n > 9 {
                n = 1;
                m += 1;
            }
            if x >= low && x <= high {
                res.push(x);
            }
        }
        res
    }
}