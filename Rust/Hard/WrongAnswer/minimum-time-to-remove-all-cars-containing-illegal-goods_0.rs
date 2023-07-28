impl Solution {
    pub fn minimum_time(s: String) -> i32 {
        
        let mut left = 0;
        let mut right = s.len() - 1;
        let mut res = 0;
        while left < right {
            if s.chars().nth(left).unwrap() == '1' {
                res += 1;
                while left < right && s.chars().nth(right).unwrap() == '1' {
                    right -= 1;
                }
                if left < right && s.chars().nth(right).unwrap() == '0' {
                    res += 1;
                    right -= 1;
                }
            } else {
                left += 1;
            }
        }
        if left == right && s.chars().nth(left).unwrap() == '1' {
            res += 1;
        }
        res
    }
}