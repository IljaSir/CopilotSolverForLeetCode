impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut vowels = 0;
        let mut i = 0;
        let mut j = s.len() - 1;

        while i < j {
            if is_vowel(s.chars().nth(i).unwrap()) {
                vowels += 1;
            }
            if is_vowel(s.chars().nth(j).unwrap()) {
                vowels -= 1;
            }
            i += 1;
            j -= 1;
        }

        vowels == 0
    }
}