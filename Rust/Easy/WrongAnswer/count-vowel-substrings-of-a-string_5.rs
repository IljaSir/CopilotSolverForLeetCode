impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut count = 0;
        let mut vowel = vec![0; 5];
        for c in word.chars() {
            let idx = match c {
                'a' => 0,
                'e' => 1,
                'i' => 2,
                'o' => 3,
                'u' => 4,
                _ => unreachable!(),
            };
            vowel[idx] += 1;
            if idx > 0 {
                vowel[idx] += vowel[idx - 1];
            }
            count += vowel[idx];
        }
        count
    }
}