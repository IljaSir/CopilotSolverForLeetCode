impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut s = secret.chars().collect::<Vec<char>>();
        let mut g = guess.chars().collect::<Vec<char>>();
        let mut bulls = 0;
        let mut cows = 0;
        for i in 0..s.len() {
            if s[i] == g[i] {
                bulls += 1;
                s[i] = ' ';
                g[i] = ' ';
            }
        }
        for i in 0..s.len() {
            if s[i] == ' ' {
                continue;
            }
            for j in 0..g.len() {
                if g[j] == ' ' {
                    continue;
                }
                if s[i] == g[j] {
                    cows += 1;
                    s[i] = ' ';
                    g[j] = ' ';
                    break;
                }
            }
        }
        format!("{}A{}B", bulls, cows)
    }
}