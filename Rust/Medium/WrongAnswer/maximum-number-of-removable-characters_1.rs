impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut left = 0;
        let mut right = removable.len();
        while left < right {
            let mid = left + (right - left) / 2;
            if Solution::is_subsequence(&s, &p, &removable[..mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left as i32 - 1
    }
    pub fn is_subsequence(s: &[char], p: &[char], removable: &[i32]) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        while i < s.len() && j < p.len() {
            if k < removable.len() && i == removable[k] as usize {
                i += 1;
                k += 1;
            } else if s[i] == p[j] {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        j == p.len()
    }
}