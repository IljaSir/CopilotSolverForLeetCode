impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut map = vec![0; 26*26];
        for word in words {
            let mut a = word.chars().nth(0).unwrap() as usize - 'a' as usize;
            let mut b = word.chars().nth(1).unwrap() as usize - 'a' as usize;
            if a > b {
                std::mem::swap(&mut a, &mut b);
            }
            map[a*26+b] = word.len().max(map[a*26+b]);
        }
        let mut ans = 0;
        for i in 0..26 {
            for j in 0..26 {
                if i == j {
                    ans += map[i*26+j] / 2 * 2;
                } else {
                    ans += map[i*26+j].min(map[j*26+i]);
                }
            }
        }
        ans
    }
}