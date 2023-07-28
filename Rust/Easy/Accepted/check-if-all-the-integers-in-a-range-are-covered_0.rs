impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        for i in left..=right {
            let mut covered = false;
            for j in 0..ranges.len() {
                if i >= ranges[j][0] && i <= ranges[j][1] {
                    covered = true;
                    break;
                }
            }
            if !covered {
                return false;
            }
        }
        true
    }
}