impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let n = arr.len();
        let mut masks = vec![0; n];
        let mut ans = 0;
        for (i, word) in arr.iter().enumerate() {
            let mut mask = 0;
            for c in word.chars() {
                let bit = 1 << (c as u8 - b'a');
                if (mask & bit) > 0 {
                    mask = 0;
                    break;
                }
                mask |= bit;
            }
            masks[i] = mask;
        }
        let mut dfs = |i: usize, mask: i32| {
            if mask.count_ones() > ans as u32 {
                ans = mask.count_ones();
            }
            for j in i..n {
                if masks[j] > 0 && (mask & masks[j]) == 0 {
                    dfs(j + 1, mask | masks[j]);
                }
            }
        };
        dfs(0, 0);
        ans as i32
    }
}