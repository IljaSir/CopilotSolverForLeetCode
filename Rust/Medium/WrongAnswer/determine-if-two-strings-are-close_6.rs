impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut char_count1 = vec![0; 26];
        let mut char_count2 = vec![0; 26];
        for c in word1.chars() {
            char_count1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            char_count2[c as usize - 'a' as usize] += 1;
        }
        let mut char_count1 = char_count1.into_iter().filter(|&x| x > 0).collect::<Vec<_>>();
        let mut char_count2 = char_count2.into_iter().filter(|&x| x > 0).collect::<Vec<_>>();
        char_count1.sort();
        char_count2.sort();
        char_count1 == char_count2
    }
}