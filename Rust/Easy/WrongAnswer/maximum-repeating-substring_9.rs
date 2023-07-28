impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut k = 0;
        let mut i = 0;
        let mut j = 0;
        let mut seq = sequence.chars().collect::<Vec<char>>();
        let mut wrd = word.chars().collect::<Vec<char>>();
        while i < seq.len() {
            if seq[i] == wrd[j] {
                i += 1;
                j += 1;
                if j == wrd.len() {
                    k += 1;
                    j = 0;
                }
            } else {
                i += 1;
                j = 0;
            }
        }
        k
    }
}