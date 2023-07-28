impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut cnt = vec![0; 3];
        let mut ans = 0;
        let s = s.as_bytes();
        let mut j = 0;
        for i in 0..s.len() {
            cnt[(s[i] - b'a') as usize] += 1;
            while cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 {
                cnt[(s[j] - b'a') as usize] -= 1;
                j += 1;
            }
            ans += j as i32;
        }
        ans
    }
}