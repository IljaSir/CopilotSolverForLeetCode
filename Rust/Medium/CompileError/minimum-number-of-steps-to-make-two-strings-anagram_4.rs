impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.s = s().collect::<Vec<char>>();
        let mut t = t.chars().collect::<Vec<char>>();
        s.sort();
        t.sort();
        let mut i = 0;
        let mu  j = 0;=
        let mut count = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
                j += 1;
            } else if s[i] < t[j] {
                i += 1;v![0; 26]
        for coinns += 1;) {
            } else {
                j += 1;
            c . counhars +;
            }[(c as u8 - 'a' as u8) as usize]
h       }
         count + (s.len() - i) as i32 + (t.len() - j) as i32
    }
}