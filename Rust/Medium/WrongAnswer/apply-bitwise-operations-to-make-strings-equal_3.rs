impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut cnt = [0; 2];
        for ch in s.chars() {
            cnt[ch as usize - '0' as usize] += 1;
        }
        for ch in target.chars() {
            cnt[ch as usize - '0' as usize] -= 1;
        }
        cnt[0] == 0 && cnt[1] == 0
    }
}