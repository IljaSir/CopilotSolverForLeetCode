impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut l = start_pos;
        let mut r = start_pos;
        let mut sum = fruits[start_pos as usize][1];
        let mut basket = vec![fruits[start_pos as usize][0]];
        while l > 0 || r < fruits.len() as i32 - 1 {
            if l > 0 && (r == fruits.len() as i32 - 1 || fruits[(l - 1) as usize][0] > fruits[(r + 1) as usize][0]) {
                l -= 1;
                if basket.len() == 2 && basket[0] != fruits[l as usize][0] {
                    sum -= fruits[l as usize][1];
                    basket.remove(0);
                }
            } else {
                r += 1;
                if basket.len() == 2 && basket[1] != fruits[r as usize][0] {
                    sum -= fruits[r as usize][1];
                    basket.remove(1);
                }
            }
            if basket.len() < 2 || basket[0] == fruits[l as usize][0] || basket[1] == fruits[l as usize][0] {
                sum += fruits[l as usize][1];
                basket.push(fruits[l as usize][0]);
            }
            if basket.len() < 2 || basket[0] == fruits[r as usize][0] || basket[1] == fruits[r as usize][0] {
                sum += fruits[r as usize][1];
                basket.push(fruits[r as usize][0]);
            }
            if basket.len() > 2 {
                sum -= fruits[l as usize][1];
                basket.remove(0);
            }
            if basket.len() > 2 {
                sum -= fruits[r as usize][1];
                basket.remove(1);
            }
            if basket.len() == 2 && r - l <= k {
                res = res.max(sum);
            }
        }
        res
    }
}