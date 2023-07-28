impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        let mut i = 0;
        while i < words.len() {
            let mut j = i + 1;
            let mut found = false;
            while j < words.len() {
                if Solution::is_anagram(&words[i], &words[j]) {
                    words.remove(j);
                    found = true;
                } else {
                    j += 1;
                }
            }
            if found {
                words.remove(i);
            } else {
                i += 1;
            }
        }
        words
    }
    fn is_anagram(word1: &str, word2: &str) -> bool {
        if word1.len() != word2.len() {
            return false;
        }
        let mut chars = vec![0; 26];
        for c in word1.chars() {
            chars[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            chars[c as usize - 'a' as usize] -= 1;
        }
        chars.iter().all(|&x| x == 0)
    }
}