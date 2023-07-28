impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        
        for w in words {
            let mut i = 0;
            let mut j = w.len() - 1;
            let mut ok = true;
            while i < j {
                if w.as_bytes()[i] != w.as_bytes()[j] {
                    ok = false;
                    break;
                }
                i += 1;
                j -= 1;
            }
            if ok {
                return w;
            }
        }
        "".to_string()
    }
}