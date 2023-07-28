impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut l = 0;
        let mut r = removable.len();
        while l < r {
            let m = (l + r + 1) >> 1;
            if Solution::is_subsequence(&s, &p, &removable[..m]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
    fn is_subsequence(s: &Vec<char>, p: &Vec<char>, removable: &[i32]) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        while i < s.len() && j < p.len() {
            if k < removable.len() && removable[k] == i as i32 {
                k += 1;
                i += 1;
            } else {
                if s[i] == p[j] {
                    j += 1;
                }
                i += 1;
            }
        }
        j == p.len()
    }
}