impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut words = words;
        let mut i = 0;
        while i < words.len() - 1 {
            let mut j = i + 1;
            while j < words.len() {
                if Self::is_anagram(&words[i], &words[j]) {
                    words.remove(j);
                } else {
                    j += 1;
                }
            }
            i += 1;
        }
        words
    }
    fn is_anagram(a: &str, b: &str) -> bool {
        if a == b {
            return true;
        }
        let mut a = a.chars().collect::<Vec<_>>();
        let mut b = b.chars().collect::<Vec<_>>();
        a.sort();
        b.sort();
        a == b
    }
}