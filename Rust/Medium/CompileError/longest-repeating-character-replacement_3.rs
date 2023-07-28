impl Solution {
    pub fn character_replacement(s: String, k: i32) -> i32 {
        

        let mut ans = 0;
        let mut cnt = vec![0; 26];
        let mut maxn = 0;
        let mut left = 0;
        let mut right = 0;
        let s = s.as_bytes();
        while right < s.len() {
            cnt[(s[right] - b'A') as usize] += 1;
            maxn = maxn.max(cnt[(s[right] - b'A') as usize]);
            if right - left + 1 - maxn > k {
                cnt[(s[left] - b'A') as usize] -= 1;
                left += 1;
            }
            ans = ans.max(right - left + 1);
            right += 1;
        }
        ans as i32
    }
}