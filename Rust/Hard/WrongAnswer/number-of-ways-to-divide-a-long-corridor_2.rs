impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut res = 1;
        let mut cnt = 0;
        for c in corridor.chars() {
            if c == 'S' {
                cnt += 1;
            } else {
                if cnt > 0 {
                    res = (res * cnt) % 1_000_000_007;
                    cnt -= 1;
                }
            }
        }
        if cnt > 0 {
            0
        } else {
            (res - 1) as i32
        }
    }
}