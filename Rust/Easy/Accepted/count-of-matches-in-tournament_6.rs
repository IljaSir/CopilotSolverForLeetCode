impl Solution {
    pub fn number_of_matches(n: i32) -> i32 {
        
        if n == 1 {
            return 0;
        }
        let mut count = 0;
        let mut teams = n;
        while teams > 1 {
            if teams % 2 == 0 {
                teams = teams / 2;
                count += teams;
            } else {
                teams = teams / 2 + 1;
                count += teams - 1;
            }
        }
        count
    }
}