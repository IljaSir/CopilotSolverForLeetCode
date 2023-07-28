impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut i = start_pos as usize;
        let mut j = start_pos as usize;
        let mut k = k as usize;
        let mut fruits = fruits;
        let mut basket = vec![0; 200001];
        let mut cnt = 0;
        while k > 0 && i < fruits.len() || j < fruits.len() {
            if basket[fruits[i][0] as usize] == 0 {
                cnt += 1;
            }
            basket[fruits[i][0] as usize] += 1;
            ans = ans.max(cnt);
            if i < fruits.len() {
                i += 1;
            }
            k -= 1;
            while cnt > 2 {
                basket[fruits[j][0] as usize] -= 1;
                if basket[fruits[j][0] as usize] == 0 {
                    cnt -= 1;
                }
                j += 1;
            }
        }
        ans
    }
}