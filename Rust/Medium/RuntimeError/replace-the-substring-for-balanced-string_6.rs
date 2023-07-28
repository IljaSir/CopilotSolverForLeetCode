impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut count = [0; 26];
        let mut res = 0;
        for c in s.chars() {
            count[(c as u8 - b'A') as usize] += 1;
        }
        let n = s.len();
        let mut i = 0;
        for j in 0..n {
            count[(s.chars().nth(j).unwrap() as u8 - b'A') as usize] -= 1;
            while i < n && count[(s.chars().nth(i).unwrap() as u8 - b'A') as usize] <= n as i32 / 4 {
                count[(s.chars().nth(i).unwrap() as u8 - b'A') as usize] += 1;
                i += 1;
            }
            if i <= n && count[(s.chars().nth(i).unwrap() as u8 - b'A') as usize] <= n as i32 / 4 {
                res = res.min(j - i + 1);
            }
        }
        res as i32
    }
}