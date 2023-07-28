impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut ranges = ranges;
        ranges.sort_by_key(|v| v[0]);
        let mut i = 0;
        let mut j = 0;
        while i <= right as usize && j < ranges.len() {
            if i as i32 < ranges[j][0] {
                if i as i32 < left {
                    i += 1;
                    continue;
                }
                return false;
            }
            if i as i32 >= ranges[j][0] && i as i32 <= ranges[j][1] {
                i += 1;
                continue;
            }
            j += 1;
        }
        true
    }
}