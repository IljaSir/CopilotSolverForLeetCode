impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut count = [0; 4];
        for c in s.chars() {
            count[c as usize - 'Q' as usize] += 1;
        }
        let n = s.len();
        let mut res = n;
        let mut i = 0;
        for j in 0..n {
            count[s.as_bytes()[j] as usize - 'Q' as usize] -= 1;
            while i < n && count[0] <= n / 4 && count[1] <= n / 4 && count[2] <= n / 4 && count[3] <= n / 4 {
                res = res.min(j - i + 1);
                count[s.as_bytes()[i] as usize - 'Q' as usize] += 1;
                i += 1;
            }
        }
        res as i32
    }
}