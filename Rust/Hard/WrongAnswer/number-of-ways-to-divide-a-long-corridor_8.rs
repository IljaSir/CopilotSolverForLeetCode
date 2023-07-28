impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let modu = 1000000007;
        let mut s = 0;
        let mut p = 0;
        let mut last_s = 0;
        let mut last_p = 0;
        let mut ans = 1;
        for c in corridor.chars() {
            if c == 'S' {
                s += 1;
                if p > 0 {
                    ans = ans * (last_s + last_p) % modu;
                    last_p = 0;
                }
                last_s += 1;
            } else {
                p += 1;
                last_p += 1;
            }
        }
        if s == 2 {
            ans = 2;
        }
        ans
    }
}