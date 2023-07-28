impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut res = 0;
        let mut l = 0;
        let mut r = 0;
        let mut last = 'S';
        for c in directions.chars() {
            if c == 'L' {
                l += 1;
                if last == 'R' {
                    res += 2;
                }
            } else if c == 'R' {
                r += 1;
                if last == 'L' {
                    res += 2;
                }
            } else {
                if last == 'L' {
                    res += l;
                } else if last == 'R' {
                    res += r;
                }
                l = 0;
                r = 0;
            }
            last = c;
        }
        if last == 'L' {
            res += l;
        } else if last == 'R' {
            res += r;
        }
        res
    }
}