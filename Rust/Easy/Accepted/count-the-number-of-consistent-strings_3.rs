impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for word in words {
            let mut flag = true;
            for ch in word.chars() {
                if !allowed.contains(ch) {
                    flag = false;
                    break;
                }
            }
            if flag {
                count += 1;
            }
        }
        count
    }
}