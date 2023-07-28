impl Solution {
    pub fn get_hint(secret: String, guess: String) -> String {
        

        let mut a = 0;
        let mut b = 0;
        let mut map = vec![0; 10];
        for (i, j) in secret.chars().zip(guess.chars()) {
            if i == j {
                a += 1;
            } else {
                if map[i as usize - '0' as usize] < 0 {
                    b += 1;
                }
                if map[j as usize - '0' as usize] > 0 {
                    b += 1;
                }
                map[i as usize - '0' as usize] += 1;
                map[j as usize - '0' as usize] -= 1;
            }
        }
        format!("{}A{}B", a, b)
    }
}