impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut count = vec![0; 26];
        let mut max = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let c = s[i] - b'a';
            if i > 0 && (s[i-1] + 1) % 26 != c {
                max = 0;
            }
            max += 1;
            count[c as usize] = count[c as usize].max(max);
        }
        count.iter().sum()
    }
}