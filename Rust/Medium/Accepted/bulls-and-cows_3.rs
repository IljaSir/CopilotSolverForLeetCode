impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut secret = secret.chars().collect::<Vec<char>>();
        let mut guess = guess.chars().collect::<Vec<char>>();
        let mut bulls = 0;
        let mut cows = 0;
        let mut i = 0;
        while i < secret.len() {
            if secret[i] == guess[i] {
                secret.remove(i);
                guess.remove(i);
                bulls += 1;
            } else {
                i += 1;
            }
        }
        for (i, c) in secret.iter().enumerate() {
            if let Some(j) = guess.iter().position(|x| x == c) {
                cows += 1;
                guess.remove(j);
            }
        }
        format!("{}A{}B", bulls, cows)
    }
}