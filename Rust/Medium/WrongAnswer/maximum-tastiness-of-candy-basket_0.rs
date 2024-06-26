impl Solution {
    pub fn maximum_tastiness(price: Vec<i32>, k: i32) -> i32 {
        
        let mut price = price;
        price.sort();
        let mut ans = std::i32::MAX;
        for i in 0..price.len() - k as usize + 1 {
            ans = ans.min(price[i + k as usize - 1] - price[i]);
        }
        ans
    }
}