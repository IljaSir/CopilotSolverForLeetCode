impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        

        let mut l = 0;
        let mut r = (c as f64).sqrt() as i32;
        while l <= r {
            let sum = l * l + r * r;
            if sum == c {
                return true;
            }
            if sum < c {
                l += 1;
            } else {
                r -= 1;
            }
        }
        false
    }
}