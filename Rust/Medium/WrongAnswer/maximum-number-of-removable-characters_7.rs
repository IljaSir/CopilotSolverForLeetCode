impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut lo = 0;
        let mut hi = removable.len() as i32;
        while lo < hi {
            let mid = lo + (hi - lo + 1) / 2;
            if Self::is_subsequence(&s, &p, &removable, mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        lo
    }
    fn is_subsequence(s: &str, p: &str, removable: &[i32], k: i32) -> bool {
        let mut s = s.to_string();
        for i in 0..k {
            s.remove(removable[i as usize] as usize);
        }
        let mut j = 0;
        for c in s.chars() {
            if j < p.len() && p.chars().nth(j).unwrap() == c {
                j += 1;
            }
        }
        j == p.len()
    }
}