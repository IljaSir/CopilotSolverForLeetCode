impl Solution {
    pub fn maximum_tastiness(price: Vec<i32>, k: i32) -> i32 {
        
        let mut price = price;
        price.sort();
        let mut left = 0;
        let mut right = k as usize - 1;
        let mut max_diff = price[right] - price[left];
        while right < price.len() {
            max_diff = max_diff.max(price[right] - price[left]);
            left += 1;
            right += 1;
        }
        max_diff
    }
}