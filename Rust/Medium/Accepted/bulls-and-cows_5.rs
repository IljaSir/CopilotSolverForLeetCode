impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut bull = 0;
        let mut cow = 0;
        let mut secret_map = [0; 10];
        let mut guess_map = [0; 10];
        for (s, g) in secret.chars().zip(guess.chars()) {
            if s == g {
                bull += 1;
            } else {
                secret_map[s as usize - 48] += 1;
                guess_map[g as usize - 48] += 1;
            }
        }
        for i in 0..10 {
            cow += secret_map[i].min(guess_map[i]);
        }
        format!("{}A{}B", bull, cow)
    }
}