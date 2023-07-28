impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut map: Vec<Vec<bool>> = vec![vec![false; 26]; 26];
        for word in words {
            let (a, b) = (word.chars().nth(0).unwrap() as u8 - 97, word.chars().nth(1).unwrap() as u8 - 97);
            map[a as usize][b as usize] = true;
            map[b as usize][a as usize] = true;
        }
        let mut max = 0;
        for i in 0..26 {
            for j in 0..26 {
                if map[i][j] {
                    let mut count = 0;
                    for k in 0..26 {
                        if map[i][k] && map[j][k] {
                            count += 1;
                        }
                    }
                    max = max.max(count);
                }
            }
        }
        max * 2
    }
}