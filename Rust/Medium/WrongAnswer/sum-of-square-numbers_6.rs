impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        

        let mut l = 0;
        let mut r = (c as f64).sqrt() as i32;
        while l <= r {
            let sum = l * l + r * r;
            if sum == c {
                return true;
            } else if sum > c {
                r -= 1;
            } else {
                l += 1;
            }
        }
        false
    }
}