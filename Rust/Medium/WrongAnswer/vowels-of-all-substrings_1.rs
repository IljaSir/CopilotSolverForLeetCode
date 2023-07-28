impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        word.bytes()
            .map(|x| match x {
                b'a' | b'e' | b'i' | b'o' | b'u' => 1,
                _ => 0,
            })
            .scan(0, |state, x| {
                *state += x;
                Some(*state)
            })
            .sum()
    }
}