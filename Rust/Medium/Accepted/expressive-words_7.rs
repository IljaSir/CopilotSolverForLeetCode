impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for w in words {
            let mut i = 0;
            let mut j = 0;
            let mut flag = true;
            while i < s.len() && j < w.len() {
                if s[i..].starts_with(&w[j..j+1]) {
                    let mut count1 = 1;
                    let mut count2 = 1;
                    let mut k = i + 1;
                    while k < s.len() && s[k..].starts_with(&w[j..j+1]) {
                        count1 += 1;
                        k += 1;
                    }
                    k = j + 1;
                    while k < w.len() && w[k..].starts_with(&w[j..j+1]) {
                        count2 += 1;
                        k += 1;
                    }
                    if count1 < count2 || (count1 < 3 && count1 != count2) {
                        flag = false;
                        break;
                    }
                    i += count1;
                    j += count2;
                } else {
                    flag = false;
                    break;
                }
            }
            if i < s.len() || j < w.len() {
                flag = false;
            }
            if flag {
                res += 1;
            }
        }
        res
    }
}