impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut count = vec![vec![0; 5]; words.len() + 1];
        for i in 0..words.len() {
            let mut j = 0;
            for c in words[i].chars() {
                if c == 'a' {
                    count[i + 1][0] = count[i][0] + 1;
                    count[i + 1][1] = count[i][1];
                    count[i + 1][2] = count[i][2];
                    count[i + 1][3] = count[i][3];
                    count[i + 1][4] = count[i][4];
                } else if c == 'e' {
                    count[i + 1][0] = count[i][0];
                    count[i + 1][1] = count[i][1] + count[i][0];
                    count[i + 1][2] = count[i][2];
                    count[i + 1][3] = count[i][3];
                    count[i + 1][4] = count[i][4];
                } else if c == 'i' {
                    count[i + 1][0] = count[i][0];
                    count[i + 1][1] = count[i][1];
                    count[i + 1][2] = count[i][2] + count[i][1];
                    count[i + 1][3] = count[i][3];
                    count[i + 1][4] = count[i][4];
                } else if c == 'o' {
                    count[i + 1][0] = count[i][0];
                    count[i + 1][1] = count[i][1];
                    count[i + 1][2] = count[i][2];
                    count[i + 1][3] = count[i][3] + count[i][2];
                    count[i + 1][4] = count[i][4];
                } else if c == 'u' {
                    count[i + 1][0] = count[i][0];
                    count[i + 1][1] = count[i][1];
                    count[i + 1][2] = count[i][2];
                    count[i + 1][3] = count[i][3];
                    count[i + 1][4] =
    }
}