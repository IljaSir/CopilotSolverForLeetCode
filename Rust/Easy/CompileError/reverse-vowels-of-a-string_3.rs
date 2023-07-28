impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut l = 0;
        let mut r = s.len() - 1;
        while l < r {
            if !is_vowel(s[l]) {
                l += 1;
                continue;
            }
            if !is_vowel(s[r]) {
                r -= 1;
                continue;
            }
            s.swap(l, r);
            l += 1;
            r -= 1;
        }
        s.iter().collect()
    }
}