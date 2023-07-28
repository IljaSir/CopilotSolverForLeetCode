impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut ret = 0;
        let mut left = 0;
        let mut right = 0;
        for c in directions.chars() {
            if c == 'R' {
                ret += left;
                right += 1;
            } else if c == 'L' {
                ret += right;
                left += 1;
            } else {
                ret += left;
                ret += right;
            }
        }
        ret
    }
}