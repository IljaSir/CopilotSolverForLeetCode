impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        
        let mut cnt = 0;
        for w in words {
            let mut flag = true;
            for c in w.chars() {
                if !allowed.contains(c) {
                    flag = false;
                    break;
                }
            }
            if flag {
                cnt += 1;
            }
        }
        cnt
    }
}