impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut l = start_pos as usize;
        let mut r = start_pos as usize;
        let mut cnt = vec![0; 2 * 10i32.pow(5) as usize + 1];
        let mut total = 0;
        let mut types = 0;
        while r < fruits.len() && r - l < k as usize {
            if cnt[fruits[r][0] as usize] == 0 {
                types += 1;
            }
            cnt[fruits[r][0] as usize] += fruits[r][1];
            total += fruits[r][1];
            r += 1;
            while types > 2 {
                cnt[fruits[l][0] as usize] -= fruits[l][1];
                total -= fruits[l][1];
                if cnt[fruits[l][0] as usize] == 0 {
                    types -= 1;
                }
                l += 1;
            }
            res = res.max(total);
        }
        res
    }
}