impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut s = s;
        let mut i = 0;
        let mut j = s.len() - 1;
        let vowels = "aeiouAEIOU";
        while i < j {
            let c1 = s.as_bytes()[i] as char;
            let c2 = s.as_bytes()[j] as char;
            if vowels.contains(c1) && vowels.contains(c2) {
                s.replace_range(i..i+1, &c2.to_string());
                s.replace_range(j..j+1, &c1.to_string());
                i += 1;
                j -= 1;
            }
            if !vowels.contains(c1) {
                i += 1;
            }
            if !vowels.contains(c2) {
                j -= 1;
            }
        }
        s
    }
}