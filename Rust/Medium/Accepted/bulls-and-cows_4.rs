impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut bulls = 0;
        let mut cows = 0;
        let mut secret_hash: Vec<i32> = vec![0; 10];
        let mut guess_hash: Vec<i32> = vec![0; 10];
        for (i, c) in secret.chars().enumerate() {
            if c == guess.chars().nth(i).unwrap() {
                bulls += 1;
            } else {
                secret_hash[c as usize - '0' as usize] += 1;
                guess_hash[guess.chars().nth(i).unwrap() as usize - '0' as usize] += 1;
            }
        }
        for i in 0..10 {
            cows += secret_hash[i].min(guess_hash[i]);
        }
        format!("{}A{}B", bulls, cows)
    }
}