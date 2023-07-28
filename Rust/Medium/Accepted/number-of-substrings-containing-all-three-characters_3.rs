impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut res = 0;
        let mut cnt = [0; 3];
        let mut left = 0;
        let mut right = 0;
        while right < s.len() {
            cnt[s.as_bytes()[right] as usize - 97] += 1;
            while cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 {
                cnt[s.as_bytes()[left] as usize - 97] -= 1;
                left += 1;
            }
            res += left;
            right += 1;
        }
        res as i32
    }
}