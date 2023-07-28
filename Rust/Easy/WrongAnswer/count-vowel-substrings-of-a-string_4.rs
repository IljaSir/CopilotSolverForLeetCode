impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut ans = 0;
        let word = word.as_bytes();
        for i in 0..word.len() {
            let mut vowel = [false; 5];
            for j in i..word.len() {
                match word[j] {
                    b'a' => vowel[0] = true,
                    b'e' => vowel[1] = true,
                    b'i' => vowel[2] = true,
                    b'o' => vowel[3] = true,
                    b'u' => vowel[4] = true,
                    _ => (),
                }
                if vowel.iter().all(|&x| x) {
                    ans += 1;
                }
            }
        }
        ans
    }
}