impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut a = vec![];
        for s in arr {
            let mut bits = 0;
            for c in s.as_bytes() {
                let bit = 1 << (c - b'a');
                if bits & bit != 0 {
                    bits = 0;
                    break;
                }
                bits |= bit;
            }
            if bits > 0 {
                a.push(bits);
            }
        }
        let mut ans = 0;
        let mut dfs = |i: usize, bits: i32| {
            if bits.count_ones() > ans as u32 {
                ans = bits.count_ones();
            }
            if i == a.len() {
                return;
            }
            for j in i..a.len() {
                if bits & a[j] == 0 {
                    dfs(j + 1, bits | a[j]);
                }
            }
        };
        dfs(0, 0);
        ans as i32
    }
}