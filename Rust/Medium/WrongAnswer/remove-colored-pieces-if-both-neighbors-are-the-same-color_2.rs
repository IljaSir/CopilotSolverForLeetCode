impl Solution {
    pub fn winner_of_game(colors: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut a_count = 0;
        let mut b_count = 0;
        for i in 0..colors.len() {
            if colors.chars().nth(i).unwrap() == 'A' {
                a_count += 1;
                if i > 0 && colors.chars().nth(i - 1).unwrap() == 'A' {
                    a += a_count;
                }
            } else {
                a_count = 0;
            }
            if colors.chars().nth(i).unwrap() == 'B' {
                b_count += 1;
                if i > 0 && colors.chars().nth(i - 1).unwrap() == 'B' {
                    b += b_count;
                }
            } else {
                b_count = 0;
            }
        }
        a > b
    }
}