impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut res = 0;
        let mut last = vec![0; 5];
        for c in word.as_bytes() {
            let i = (c - b'a') as usize;
            last[i] = 1 + last.iter().take(i).sum::<i32>();
            res += last[i];
        }
        res
    }
}