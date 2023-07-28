impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        

        let mut i = 0;
        let mut j = (c as f64).sqrt() as i32;
        while i <= j {
            let sum = i * i + j * j;
            if sum == c {
                return true;
            }
            if sum < c {
                i += 1;
            } else {
                j -= 1;
            }
        }
        false
    }
}