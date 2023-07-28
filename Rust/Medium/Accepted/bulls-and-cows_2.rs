impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut bulls = 0;
        let mut cows = 0;
        let mut secret_chars = secret.chars().collect::<Vec<char>>();
        let mut guess_chars = guess.chars().collect::<Vec<char>>();
        for i in 0..secret_chars.len() {
            if secret_chars[i] == guess_chars[i] {
                bulls += 1;
                secret_chars[i] = '-';
                guess_chars[i] = '-';
            }
        }
        for i in 0..secret_chars.len() {
            if secret_chars[i] != '-' {
                if let Some(j) = guess_chars.iter().position(|&x| x == secret_chars[i]) {
                    cows += 1;
                    guess_chars[j] = '-';
                }
            }
        }
        format!("{}A{}B", bulls, cows)
    }
}