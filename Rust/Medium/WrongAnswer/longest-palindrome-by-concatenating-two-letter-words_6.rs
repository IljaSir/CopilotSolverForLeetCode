impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut count = vec![0; 26 * 26];
        for word in words {
            let mut a = word.as_bytes()[0] - b'a';
            let mut b = word.as_bytes()[1] - b'a';
            if a > b {
                std::mem::swap(&mut a, &mut b);
            }
            let i = (a * 26 + b) as usize;
            count[i] = count[i].max(word.len() as i32);
        }
        for i in 0..26 {
            for j in 0..26 {
                let a = (i * 26 + j) as usize;
                for k in 0..26 {
                    let b = (j * 26 + k) as usize;
                    ans = ans.max(count[a] + count[b]);
                }
            }
        }
        ans
    }
}