impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut map = vec![0; 26 * 26];
        for word in words {
            let mut key = (word.as_bytes()[0] - b'a') as usize;
            key = key * 26 + (word.as_bytes()[1] - b'a') as usize;
            map[key] = word.len().max(map[key]);
        }
        for i in 0..26 {
            for j in 0..26 {
                let key = i * 26 + j;
                if map[key] == 0 {
                    continue;
                }
                ans += map[key];
                for k in j + 1..26 {
                    let key2 = i * 26 + k;
                    if map[key2] > 0 && i != k {
                        ans += map[key2];
                        map[key2] = 0;
                    }
                }
                break;
            }
        }
        ans
    }
}