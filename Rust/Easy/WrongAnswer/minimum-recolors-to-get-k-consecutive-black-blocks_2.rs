impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let mut blocks = blocks.chars().collect::<Vec<char>>();
        let mut ans = 0;
        let mut i = 0;
        while i < blocks.len() {
            if blocks[i] == 'B' {
                i += 1;
            } else {
                let mut j = i + 1;
                while j < blocks.len() && blocks[j] == 'W' {
                    j += 1;
                }
                let mut k = 0;
                while i + k < j {
                    blocks[i + k] = 'B';
                    k += 1;
                }
                ans += (j - i - 1) / k as usize;
                i = j;
            }
        }
        ans as i32
    }
}