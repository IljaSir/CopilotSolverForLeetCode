impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = removable.len();
        let mut s = s.into_bytes();
        let p = p.into_bytes();
        while l < r {
            let mid = (l + r + 1) / 2;
            for i in 0..mid {
                s[removable[i] as usize] = b'\0';
            }
            if Self::is_subsequence(&s, &p) {
                l = mid;
            } else {
                for i in 0..mid {
                    s[removable[i] as usize] = removable[i] as u8;
                }
                r = mid - 1;
            }
        }
        l as i32
    }
    fn is_subsequence(s: &[u8], p: &[u8]) -> bool {
        let mut i = 0;
        for j in 0..s.len() {
            if s[j] == p[i] {
                i += 1;
                if i == p.len() {
                    return true;
                }
            }
        }
        false
    }
}