impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for word in words {
            let mut flag = true;
            for ch in word.chars() {
                if !allowed.contains(ch) {
                    flag = false;
                    break;
                }
            }
            if flag {
                res += 1;
            }
        }
        res
    }
}