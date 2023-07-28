impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut i = 0;
        while i < words.len() {
            let mut j = i + 1;
            while j < words.len() {
                if is_anagram(&words[i], &words[j]) {
                    break;
                }
                j += 1;
            }
            if j == words.len() {
                result.push(words[i].clone());
            }
            i += 1;
        }
        result
    }
}