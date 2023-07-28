impl Solution {
    pub fn winner_of_game(colors: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        while i < colors.len() {
            if colors[i..].starts_with("AA") {
                let mut j = i + 2;
                while j < colors.len() && colors[j..].starts_with("A") {
                    j += 1;
                }
                a += j - i - 1;
                i = j;
            } else if colors[i..].starts_with("BB") {
                let mut j = i + 2;
                while j < colors.len() && colors[j..].starts_with("B") {
                    j += 1;
                }
                b += j - i - 1;
                i = j;
            } else {
                i += 1;
            }
        }
        a > b
    }
}