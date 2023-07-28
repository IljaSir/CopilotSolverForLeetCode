impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        for word in words.iter() {
            let mut row = 0;
            let mut flag = true;
            for c in word.chars() {
                let temp = match c {
                    'q' | 'w' | 'e' | 'r' | 't' | 'y' | 'u' | 'i' | 'o' | 'p' => 1,
                    'a' | 's' | 'd' | 'f' | 'g' | 'h' | 'j' | 'k' | 'l' => 2,
                    'z' | 'x' | 'c' | 'v' | 'b' | 'n' | 'm' => 3,
                    _ => 0,
                };
                if row == 0 {
                    row = temp;
                } else if row != temp {
                    flag = false;
                    break;
                }
            }
            if flag {
                result.push(word.to_string());
            }
        }
        result
    }
}