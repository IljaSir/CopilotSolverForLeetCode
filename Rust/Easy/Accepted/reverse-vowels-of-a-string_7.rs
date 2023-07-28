impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut v: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = v.len() - 1;
        while i < j {
            let mut i_is_vowel = false;
            let mut j_is_vowel = false;
            if v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u' || v[i] == 'A' || v[i] == 'E' || v[i] == 'I' || v[i] == 'O' || v[i] == 'U' {
                i_is_vowel = true;
            }
            if v[j] == 'a' || v[j] == 'e' || v[j] == 'i' || v[j] == 'o' || v[j] == 'u' || v[j] == 'A' || v[j] == 'E' || v[j] == 'I' || v[j] == 'O' || v[j] == 'U' {
                j_is_vowel = true;
            }
            if i_is_vowel && j_is_vowel {
                v.swap(i, j);
                i += 1;
                j -= 1;
            } else if i_is_vowel && !j_is_vowel {
                j -= 1;
            } else if !i_is_vowel && j_is_vowel {
                i += 1;
            } else {
                i += 1;
                j -= 1;
            }
        }
        v.iter().collect()
    }
}