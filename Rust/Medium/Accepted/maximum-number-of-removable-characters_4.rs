impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = removable.len();
        let mut s = s.as_bytes().to_vec();
        let p = p.as_bytes().to_vec();
        while left < right {
            let mid = (left + right + 1) / 2;
            let mut mask = vec![true; s.len()];
            for i in 0..mid {
                mask[removable[i] as usize] = false;
            }
            if Solution::check(&s, &p, &mask) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        left as i32
    }
    fn check(s: &Vec<u8>, p: &Vec<u8>, mask: &Vec<bool>) -> bool {
        let mut i = 0;
        for j in 0..s.len() {
            if mask[j] && s[j] == p[i] {
                i += 1;
                if i == p.len() {
                    return true;
                }
            }
        }
        false
    }
}