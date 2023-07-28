impl Solution {
    pub fn winner_of_game(colors: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        while i < colors.len() {
            if colors[i..].starts_with("AAA") {
                a += 1;
                i += 3;
            } else if colors[i..].starts_with("BBB") {
                b += 1;
                i += 3;
            } else {
                i += 1;
            }
        }
        a > b
    }
}