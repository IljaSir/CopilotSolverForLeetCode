impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut ways = 1;
        let mut plants = 0;
        let mut seats = 0;
        let mut last = 'S';
        for c in corridor.chars() {
            match c {
                'S' => {
                    if last == 'P' {
                        if plants == 2 {
                            ways *= 2;
                        }
                        if plants == 1 {
                            ways *= 1;
                        }
                        if plants == 0 {
                            ways *= 0;
                        }
                        ways %= 1_000_000_007;
                        plants = 0;
                    }
                    seats += 1;
                    last = 'S';
                }
                'P' => {
                    plants += 1;
                    last = 'P';
                }
                _ => {}
            }
        }
        if plants == 2 {
            ways *= 2;
        }
        if plants == 1 {
            ways *= 1;
        }
        if plants == 0 {
            ways *= 0;
        }
        ways %= 1_000_000_007;
        ways -= 1;
        if ways < 0 {
            ways += 1_000_000_007;
        }
        ways
    }
}