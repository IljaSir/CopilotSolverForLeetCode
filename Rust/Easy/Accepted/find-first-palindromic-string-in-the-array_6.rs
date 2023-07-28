impl Solution {
    pub fn first_palindrome(words: Vec<String>) -> String {
        
        for i in 0..words.len() {
            let mut j = 0;
            let mut k = words[i].len() - 1;
            let mut flag = true;
            while j < k {
                if words[i].chars().nth(j).unwrap() != words[i].chars().nth(k).unwrap() {
                    flag = false;
                    break;
                }
                j += 1;
                k -= 1;
            }
            if flag {
                return words[i].to_string();
            }
        }
        return String::new();
    }
}