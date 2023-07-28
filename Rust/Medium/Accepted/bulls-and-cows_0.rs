impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut s = secret.chars().collect::<Vec<char>>();
        let mut g = guess.chars().collect::<Vec<char>>();
        let mut a = 0;
        let mut b = 0;
        for i in 0..s.len() {
            if s[i] == g[i] {
                a += 1;
                s[i] = 'A';
                g[i] = 'A';
            }
        }
        for i in 0..s.len() {
            if s[i] == 'A' {
                continue;
            }
            for j in 0..g.len() {
                if g[j] == 'A' || s[i] != g[j] {
                    continue;
                }
                b += 1;
                g[j] = 'A';
                break;
            }
        }
        format!("{}A{}B", a, b)
    }
}