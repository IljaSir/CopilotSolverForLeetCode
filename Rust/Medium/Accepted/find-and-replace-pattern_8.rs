impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = vec![];
        for word in words.iter() {
            let mut map1 = vec![0; 26];
            let mut map2 = vec![0; 26];
            let mut is_match = true;
            for i in 0..word.len() {
                let c1 = word.chars().nth(i).unwrap() as usize - 97;
                let c2 = pattern.chars().nth(i).unwrap() as usize - 97;
                if map1[c1] == 0 && map2[c2] == 0 {
                    map1[c1] = c2 + 1;
                    map2[c2] = c1 + 1;
                } else if map1[c1] != c2 + 1 || map2[c2] != c1 + 1 {
                    is_match = false;
                    break;
                }
            }
            if is_match {
                result.push(word.to_string());
            }
        }
        result
    }
}