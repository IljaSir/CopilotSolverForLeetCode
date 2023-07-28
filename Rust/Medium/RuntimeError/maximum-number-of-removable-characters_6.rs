impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut s = s.as_bytes().to_vec();
        let p = p.as_bytes();
        let mut l = 0;
        let mut r = removable.len();
        while l < r {
            let m = l + (r - l) / 2;
            for i in 0..=m {
                s[removable[i] as usize] = 0;
            }
            let mut j = 0;
            for i in 0..s.len() {
                if s[i] == p[j] {
                    j += 1;
                    if j == p.len() {
                        break;
                    }
                }
            }
            if j == p.len() {
                l = m + 1;
            } else {
                r = m;
            }
            for i in 0..=m {
                s[removable[i] as usize] = p[i];
            }
        }
        l as i32
    }
}