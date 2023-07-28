impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut pattern = pattern.chars().collect::<Vec<char>>();
        for word in words {
            let mut word = word.chars().collect::<Vec<char>>();
            let mut m1 = vec![0; 26];
            let mut m2 = vec![0; 26];
            let mut flag = true;
            for i in 0..word.len() {
                if m1[word[i] as usize - 'a' as usize] == 0 {
                    m1[word[i] as usize - 'a' as usize] = pattern[i] as usize - 'a' as usize + 1;
                }
                if m2[pattern[i] as usize - 'a' as usize] == 0 {
                    m2[pattern[i] as usize - 'a' as usize] = word[i] as usize - 'a' as usize + 1;
                }
                if m1[word[i] as usize - 'a' as usize] != pattern[i] as usize - 'a' as usize + 1 || m2[pattern[i] as usize - 'a' as usize] != word[i] as usize - 'a' as usize + 1 {
                    flag = false;
                    break;
                }
            }
            if flag {
                res.push(word.iter().collect::<String>());
            }
        }
        res
    }
}