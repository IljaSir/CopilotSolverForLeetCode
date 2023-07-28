impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut count = 0;
        for i in 0..10 {
            let mut has_r = false;
            let mut has_g = false;
            let mut has_b = false;
            for j in 0..rings.len() {
                if j % 2 == 1 && rings.as_bytes()[j] == i + 48 {
                    if rings.as_bytes()[j - 1] == 82 {
                        has_r = true;
                    } else if rings.as_bytes()[j - 1] == 71 {
                        has_g = true;
                    } else if rings.as_bytes()[j - 1] == 66 {
                        has_b = true;
                    }
                }
            }
            if has_r && has_g && has_b {
                count += 1;
            }
        }
        count
    }
}