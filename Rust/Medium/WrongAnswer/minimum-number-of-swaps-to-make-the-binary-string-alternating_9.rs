impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut count = 0;
        for (i, c) in s.chars().enumerate() {
            if c == '0' {
                count += 1;
            }
        }
        let n = s.len();
        let mut min = 0;
        let mut max = 0;
        for (i, c) in s.chars().enumerate() {
            if i < count {
                if c == '0' {
                    min += 1;
                } else {
                    max += 1;
                }
            } else {
                if c == '0' {
                    max += 1;
                } else {
                    min += 1;
                }
            }
        }
        if min % 2 == 1 || max % 2 == 1 {
            return -1;
        }
        (min / 2).min(max / 2)
    }
}