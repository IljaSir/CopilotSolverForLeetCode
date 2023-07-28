impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let s = s.into_bytes();
        let mut cnt = vec![0; 26];
        let mut max = 0;
        let mut res = 0;
        for (i, j) in (0..s.len()).zip(0..s.len()) {
            cnt[(s[i] - b'A') as usize] += 1;
            max = max.max(cnt[(s[i] - b'A') as usize]);
            if i - j + 1 - max > k {
                cnt[(s[j] - b'A') as usize] -= 1;
                j += 1;
            }
            res = res.max(i - j + 1);
        }
        res as i32
    }
}