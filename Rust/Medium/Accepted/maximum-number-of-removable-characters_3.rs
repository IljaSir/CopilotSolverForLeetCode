impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut removable = removable;
        let mut l = 0;
        let mut r = removable.len();
        while l < r {
            let m = (l + r + 1) / 2;
            let mut t = s.clone();
            for i in 0..m {
                t[removable[i] as usize] = '0';
            }
            if Self::is_subsequence(&t, &p) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
    fn is_subsequence(s: &Vec<char>, p: &Vec<char>) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < p.len() {
            if s[i] == p[j] {
                j += 1;
            }
            i += 1;
        }
        j == p.len()
    }
}