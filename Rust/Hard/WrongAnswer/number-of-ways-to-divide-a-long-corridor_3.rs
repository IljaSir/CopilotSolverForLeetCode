impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut cnt = 0;
        let mut prev = 'S';
        for c in corridor.chars() {
            if c == 'S' {
                if prev == 'S' {
                    cnt += 1;
                }
                prev = 'S';
            } else {
                prev = 'P';
            }
        }
        let mut n = 1;
        for _ in 0..cnt {
            n = (n * 2) % 1_000_000_007;
        }
        if n != 0 {
            n -= 1;
        }
        n as i32
    }
}