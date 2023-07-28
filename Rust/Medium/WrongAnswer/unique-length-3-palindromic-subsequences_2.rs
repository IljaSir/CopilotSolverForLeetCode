impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut res = 0;
        let mut first = vec![0; 26];
        let mut last = vec![0; 26];
        let mut count = vec![0; 26];
        let s = s.as_bytes();
        for i in 0..s.len() {
            count[(s[i] - b'a') as usize] += 1;
            last[(s[i] - b'a') as usize] = i;
        }
        for i in 0..s.len() {
            let idx = (s[i] - b'a') as usize;
            if count[idx] > 1 {
                count[idx] -= 1;
                if first[idx] == 0 {
                    first[idx] = i;
                }
            }
        }
        for i in 0..26 {
            if first[i] != 0 && last[i] != 0 && first[i] < last[i] {
                res += 1;
            }
        }
        res
    }
}