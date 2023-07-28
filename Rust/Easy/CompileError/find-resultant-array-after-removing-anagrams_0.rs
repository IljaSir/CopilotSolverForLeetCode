impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        let mut i = 0;
        while i < words.len() - 1 {
            let mut j = i + 1;
            while j < words.len() {
                if Solution::is_anagram(&words[i], &words[j]) {
                    words.remove(j);
                    continue;
                }
                j += 1;
            }
            i += 1;
        }
        words
    }
}