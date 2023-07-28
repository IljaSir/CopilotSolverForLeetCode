impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut vowels = vec![vec![0; 5]; words.len() + 1];
        for (i, word) in words.iter().enumerate() {
            for j in 0..5 {
                vowels[i + 1][j] = vowels[i][j];
            }
            match word.chars().next().unwrap() {
                'a' => vowels[i + 1][0] += 1,
                'e' => vowels[i + 1][1] += 1,
                'i' => vowels[i + 1][2] += 1,
                'o' => vowels[i + 1][3] += 1,
                'u' => vowels[i + 1][4] += 1,
                _ => {}
            }
        }
        let mut ans = Vec::new();
        for q in queries {
            let mut count = 0;
            for i in 0..5 {
                count += vowels[q[1] as usize + 1][i] - vowels[q[0] as usize][i];
            }
            ans.push(count);
        }
        ans
    }
}