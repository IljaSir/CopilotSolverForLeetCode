impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut max_gap = 0;
        let mut current_gap = 0;
        let mut found_one = false;
        let mut n = n;
        while n > 0 {
            if n & 1 == 1 {
                if found_one {
                    if current_gap > max_gap {
                        max_gap = current_gap;
                    }
                    current_gap = 0;
                } else {
                    found_one = true;
                }
            } else if found_one {
                current_gap += 1;
            }
            n = n >> 1;
        }
        max_gap
    }
}