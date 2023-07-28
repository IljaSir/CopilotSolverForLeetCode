impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut cnt = [0; 3];
        let mut res = 0;
        let (mut l, mut r) = (0, 0);
        while r < s.len() {
            cnt[s.as_bytes()[r] as usize - 'a' as usize] += 1;
            while cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 {
                cnt[s.as_bytes()[l] as usize - 'a' as usize] -= 1;
                l += 1;
            }
            res += l;
            r += 1;
        }
        res as i32
    }
}