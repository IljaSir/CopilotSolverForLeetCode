impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut c = [0; 26];
        let mut f = [0; 26];
        let mut l = [0; 26];
        for (i, c) in s.chars().enumerate() {
            let i = (c as u8 - 'a' as u8) as usize;
            if c[i] == 0 {
                f[i] = i;
            }
            l[i] = i;
            c[i] += 1;
        }
        for i in 0..26 {
            if c[i] >= 2 {
                cnt += l[i] - f[i] - c[i] + 1;
            }
        }
        cnt
    }
}