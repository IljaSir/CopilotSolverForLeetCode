impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let n = s.len();
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'A' as usize] += 1;
        }
        let mut res = n;
        let mut l = 0;
        for r in 0..n {
            count[s.chars().nth(r).unwrap() as usize - 'A' as usize] -= 1;
            while l < n && count['Q' as usize - 'A' as usize] <= n / 4 && count['W' as usize - 'A' as usize] <= n / 4 && count['E' as usize - 'A' as usize] <= n / 4 && count['R' as usize - 'A' as usize] <= n / 4 {
                res = res.min(r - l + 1);
                count[s.chars().nth(l).unwrap() as usize - 'A' as usize] += 1;
                l += 1;
            }
        }
        res as i32
    }
}