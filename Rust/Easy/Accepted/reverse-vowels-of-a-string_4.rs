impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut v = s.chars().collect::<Vec<_>>();
        let mut i = 0;
        let mut j = v.len() - 1;
        while i < j {
            if !Self::is_vowel(v[i]) {
                i += 1;
                continue;
            }
            if !Self::is_vowel(v[j]) {
                j -= 1;
                continue;
            }
            v.swap(i, j);
            i += 1;
            j -= 1;
        }
        v.into_iter().collect()
    }
    fn is_vowel(c: char) -> bool {
        match c {
            'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => true,
            _ => false,
        }
    }
}