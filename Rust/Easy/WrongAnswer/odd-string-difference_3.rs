impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        for word in words.iter() {
            let mut odd = true;
            let mut diff = 0;
            for i in 0..word.len()-1 {
                let d = (word.chars().nth(i+1).unwrap() as i32) - (word.chars().nth(i).unwrap() as i32);
                if i == 0 {
                    diff = d;
                }
                else {
                    if d != diff {
                        odd = false;
                        break;
                    }
                }
            }
            if odd {
                return word.to_string();
            }
        }
        return "".to_string();
    }
}