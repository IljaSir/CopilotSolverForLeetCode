impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut ans = 0;
        let mut last = [0; 26];
        for (i, c) in s.chars().enumerate() {
            last[(c as u8 - b'a') as usize] = i;
        }
        let mut i = 0;
        while i < s.len() {
            let mut j = i;
            let mut k = i;
            while j < s.len() {
                k = k.max(last[(s.chars().nth(j).unwrap() as u8 - b'a') as usize]);
                if k == j {
                    break;
                }
                j += 1;
            }
            ans += 1;
            i = k + 1;
        }
        ans
    }
}