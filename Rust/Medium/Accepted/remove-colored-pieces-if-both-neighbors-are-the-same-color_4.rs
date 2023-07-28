impl Solution {
    pub fn winner_of_game(colors: String) -> bool {
        
        let mut count = 0;
        let mut ans = 0;
        let mut prev = ' ';
        for c in colors.chars() {
            if c == prev {
                count += 1;
            } else {
                count = 1;
                prev = c;
            }
            if c == 'A' && count >= 3 {
                ans += 1;
            }
        }
        count = 0;
        prev = ' ';
        for c in colors.chars() {
            if c == prev {
                count += 1;
            } else {
                count = 1;
                prev = c;
            }
            if c == 'B' && count >= 3 {
                ans -= 1;
            }
        }
        ans > 0
    }
}