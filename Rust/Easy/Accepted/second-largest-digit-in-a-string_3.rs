impl Solution {
    pub fn second_highest(s: String) -> i32 {
        
        let mut v = vec![false; 10];
        for c in s.chars() {
            if c >= '0' && c <= '9' {
                v[c as usize - '0' as usize] = true;
            }
        }
        let mut i = 9;
        let mut cnt = 0;
        while i >= 0 {
            if v[i as usize] {
                cnt += 1;
            }
            if cnt == 2 {
                return i;
            }
            i -= 1;
        }
        -1
    }
}