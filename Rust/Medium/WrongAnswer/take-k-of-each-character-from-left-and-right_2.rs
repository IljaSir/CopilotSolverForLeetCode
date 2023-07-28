impl Solution {
    pub fn take_characters(s: String, k: i32) -> i32 {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let n = s.len();
        let k = k as usize;
        let mut cnt = vec![0; 3];
        let mut i = 0;
        let mut j = n - 1;
        let mut res = 0;
        while i <= j {
            if i == j {
                cnt[s[i] as usize - 'a' as usize] += 1;
                break;
            }
            if s[i] == s[j] {
                cnt[s[i] as usize - 'a' as usize] += 2;
                i += 1;
                j -= 1;
            } else {
                cnt[s[i] as usize - 'a' as usize] += 1;
                cnt[s[j] as usize - 'a' as usize] += 1;
                i += 1;
                j -= 1;
            }
            res += 1;
        }
        if cnt.iter().all(|c| *c >= k) {
            res as i32
        } else {
            -1
        }
    }
}