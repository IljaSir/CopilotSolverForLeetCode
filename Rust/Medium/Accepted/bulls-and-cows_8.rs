impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut bulls = 0;
        let mut cows = 0;
        let mut secret = secret.chars().collect::<Vec<char>>();
        let mut guess = guess.chars().collect::<Vec<char>>();
        let mut secret_count = vec![0; 10];
        let mut guess_count = vec![0; 10];
        for i in 0..secret.len() {
            if secret[i] == guess[i] {
                bulls += 1;
            } else {
                secret_count[secret[i].to_digit(10).unwrap() as usize] += 1;
                guess_count[guess[i].to_digit(10).unwrap() as usize] += 1;
            }
        }
        for i in 0..10 {
            cows += secret_count[i].min(guess_count[i]);
        }
        format!("{}A{}B", bulls, cows)
    }
}