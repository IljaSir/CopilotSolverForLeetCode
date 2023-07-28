impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut fruits = fruits;
        let mut start_pos = start_pos as usize;
        let mut k = k as usize;
        let mut res = 0;
        let mut sum = 0;
        let mut l = 0;
        let mut r = 0;
        let mut n = fruits.len();
        let mut map = vec![0; 2 * 100_000 + 1];
        while r < n && k > 0 {
            let pos = fruits[r][0];
            let amount = fruits[r][1];
            if map[pos as usize] == 0 {
                k -= 1;
            }
            map[pos as usize] += amount;
            sum += amount;
            r += 1;
            while k == 0 {
                let pos = fruits[l][0];
                let amount = fruits[l][1];
                if map[pos as usize] == amount {
                    k += 1;
                }
                map[pos as usize] -= amount;
                sum -= amount;
                l += 1;
            }
            if start_pos >= l && start_pos < r {
                res = res.max(sum);
            }
        }
        res
    }
}