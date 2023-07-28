impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        

        let mut i = 0;
        while i * i <= c {
            let j = (c - i * i) as f64;
            if j.sqrt() == j.sqrt().floor() {
                return true;
            }
            i += 1;
        }
        false
    }
}