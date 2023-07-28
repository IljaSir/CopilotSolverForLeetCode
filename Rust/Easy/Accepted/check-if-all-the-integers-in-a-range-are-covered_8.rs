impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut covered = vec![false; (right - left + 1) as usize];
        for r in &ranges {
            let mut i = r[0];
            while i <= r[1] {
                if i >= left && i <= right {
                    covered[(i - left) as usize] = true;
                }
                i += 1;
            }
        }
        for c in &covered {
            if !c {
                return false;
            }
        }
        true
    }
}