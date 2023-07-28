impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        

        let mut a = 0;
        let mut b = (c as f64).sqrt() as i32;
        while a <= b {
            let sum = a*a + b*b;
            if sum == c { return true; }
            if sum < c { a += 1; }
            else { b -= 1; }
        }
        false
    }
}