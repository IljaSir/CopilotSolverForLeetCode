impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut cnt = [0; 26];
        for &c in s1 {
            cnt[c as usize - 97] += 1;
        }
        let mut left = 0;
        let mut right = 0;
        while right < s2.len() {
            if cnt[s2[right] as usize - 97] > 0 {
                cnt[s2[right] as usize - 97] -= 1;
                right += 1;
            } else {
                cnt[s2[left] as usize - 97] += 1;
                left += 1;
            }
            if right - left == s1.len() {
                return true;
            }
        }
        false
    }
}