impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut cnt = 0;
        for i in 0..s.len() {
            if (i % 2 == 0 && s[i] == '1') || (i % 2 == 1 && s[i] == '0') {
                cnt += 1;
            }
        }
        if cnt % 2 == 0 {
            cnt = cnt.min(s.len() - cnt);
        } else {
            cnt = -1;
        }
        cnt
    }
}