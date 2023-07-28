impl Solution {
    pub fn maximum_removals(s: String, p: String, removable: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = removable.len();
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        while l < r {
            let m = (l + r + 1) / 2;
            let mut t = s.clone();
            for i in 0..m {
                t[removable[i] as usize] = ' ';
            }
            let mut i = 0;
            let mut j = 0;
            while i < p.len() && j < t.len() {
                if p[i] == t[j] {
                    i += 1;
                }
                j += 1;
            }
            if i == p.len() {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
}