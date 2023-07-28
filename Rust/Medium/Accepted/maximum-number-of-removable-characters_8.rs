impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut s = s.into_bytes();
        let p = p.into_bytes();
        let mut left = 0;
        let mut right = removable.len() as i32;
        while left < right {
            let mid = left + (right - left + 1) / 2;
            let mut set = std::collections::HashSet::new();
            for i in 0..mid {
                set.insert(removable[i as usize]);
            }
            if Solution::is_subsequence(&s, &p, &set) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        left
    }
    fn is_subsequence(s: &Vec<u8>, p: &Vec<u8>, set: &std::collections::HashSet<i32>) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < p.len() {
            if set.contains(&(i as i32)) {
                i += 1;
                continue;
            }
            if s[i] == p[j] {
                j += 1;
            }
            i += 1;
        }
        j == p.len()
    }
}