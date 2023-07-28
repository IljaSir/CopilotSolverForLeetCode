impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut cnt = [0; 2];
        for c in s.chars() {
            cnt[c as usize - '0' as usize] += 1;
        }
        for c in target.chars() {
            cnt[c as usize - '0' as usize] -= 1;
        }
        cnt[0] == 0 && cnt[1] == 0
    }
}