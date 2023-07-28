impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let one = s.chars().filter(|&c| c == '1').count();
        if one % 3 != 0 {
            return 0;
        }
        let modu = 1_000_000_007;
        let one = one / 3;
        if one == 0 {
            let n = s.len() - 1;
            return ((n as i64) * (n as i64 - 1) / 2 % modu) as i32;
        }
        let mut count = 0;
        let mut i = 0;
        let mut pos = vec![];
        for c in s.chars() {
            if c == '1' {
                count += 1;
            }
            if count == one {
                pos.push(i);
                count = 0;
            }
            i += 1;
        }
        let (l, r) = (pos[0] + 1, pos[1]);
        ((r - l + 1) * (l) % modu) as i32
    }
}