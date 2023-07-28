impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = removable.len();
        let mut s = s;
        let mut p = p;
        let mut removable = removable;
        while left < right {
            let mid = left + (right - left + 1) / 2;
            for i in 0..mid {
                s.remove(removable[i] as usize);
            }
            if is_subsequence(&s, &p) {
                left = mid;
            } else {
                for i in 0..mid {
                    s.insert(removable[i] as usize, removable[i] as u8 as char);
                }
                right = mid - 1;
            }
        }
        left as i32
    }
}