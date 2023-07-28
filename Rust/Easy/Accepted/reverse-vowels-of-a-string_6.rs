impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if b"aeiouAEIOU".contains(&s[i]) && b"aeiouAEIOU".contains(&s[j]) {
                s.swap(i, j);
                i += 1;
                j -= 1;
            } else if b"aeiouAEIOU".contains(&s[i]) {
                j -= 1;
            } else if b"aeiouAEIOU".contains(&s[j]) {
                i += 1;
            } else {
                i += 1;
                j -= 1;
            }
        }
        String::from_utf8(s).unwrap()
    }
}